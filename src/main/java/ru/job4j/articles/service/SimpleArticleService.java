package ru.job4j.articles.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.articles.model.Article;
import ru.job4j.articles.model.Word;
import ru.job4j.articles.service.generator.ArticleGenerator;
import ru.job4j.articles.store.Store;

import java.util.ArrayList;
import java.util.List;

public class SimpleArticleService implements ArticleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleArticleService.class.getSimpleName());

    private final ArticleGenerator articleGenerator;

    public SimpleArticleService(ArticleGenerator articleGenerator) {
        this.articleGenerator = articleGenerator;
    }

    @Override
    public void generate(Store<Word> wordStore, int count, Store<Article> articleStore) {
        var timeBegin = System.currentTimeMillis();
        LOGGER.info("Генерация статей в количестве {}", count);
        var words = wordStore.findAll();
        int batch = 1000;
        int bigCount = count / batch;
        for (int i = 0; bigCount == 0 ? i < 1 : i < bigCount; i++) {
            List<Article> articles = new ArrayList<>();
            for (int j = 0; bigCount == 0 ? j < count : j < 1000; j++) {
                articles.add(articleGenerator.generate(words));
                LOGGER.info("Сгенерирована статья № {}", i * batch + j);
            }
            articles.forEach(articleStore::save);
        }
        System.out.println("Time = " + ((System.currentTimeMillis() - timeBegin) / 1000));
    }
}