package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")

class GeneratorTTest {

    @Test
    void whenPutThenGetCorrectResult() {
        Generator generator = new GeneratorT();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        String expect = "I am a Petr Arsentev, Who are you?";
        String res = generator.produce(template, map);
        assertThat(res).isEqualTo(expect);
    }

    @Test
    void whenTemplateHasDifferentKeyThenGetException() {
        Generator generator = new GeneratorT();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String template = "I am a ${aaa}, Who are ${subject}?";
        assertThatThrownBy(() -> generator.produce(template, map)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenMapHasExtraEntriesThenGetException() {
        Generator generator = new GeneratorT();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        map.put("subject2", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        assertThatThrownBy(() -> generator.produce(template, map)).
                isInstanceOf(IllegalArgumentException.class);
    }

}