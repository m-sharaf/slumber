package com.ms.slumber.core;

import com.ms.slumber.util.JpaUtil;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class TableStream<T> implements Stream<T> {

    private final Class<T> clazz;
    private final JdbcTemplate jdbcTemplate;

    public TableStream(Class<T> clazz, JdbcTemplate jdbcTemplate) {
        this.clazz = clazz;
        this.jdbcTemplate = jdbcTemplate;
    }

    public static <T> TableStream<T> of(Class<T> clazz, JdbcTemplate jdbcTemplate) {
        return new TableStream<>(clazz, jdbcTemplate);
    }

    @Override
    public <R, A> R collect(Collector<? super T, A, R> collector) {
        List<T> returnList = jdbcTemplate.queryForList("SELECT * FROM " + JpaUtil.findTableName(clazz), clazz);

        A a = collector.supplier().get();
        returnList.forEach(o -> collector.accumulator().accept(a, o));
        return collector.finisher().apply(a);
    }



    @Override
    public Stream<T> filter(Predicate<? super T> predicate) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public IntStream mapToInt(ToIntFunction<? super T> mapper) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public LongStream mapToLong(ToLongFunction<? super T> mapper) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public Stream<T> distinct() {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public Stream<T> sorted() {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public Stream<T> sorted(Comparator<? super T> comparator) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public Stream<T> peek(Consumer<? super T> action) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public Stream<T> limit(long maxSize) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public Stream<T> skip(long n) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public void forEachOrdered(Consumer<? super T> action) {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <A> A[] toArray(IntFunction<A[]> generator) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        throw new NotImplementedException("To be implemented.");
    }



    @Override
    public Optional<T> min(Comparator<? super T> comparator) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public Optional<T> max(Comparator<? super T> comparator) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean anyMatch(Predicate<? super T> predicate) {
        return false;
    }

    @Override
    public boolean allMatch(Predicate<? super T> predicate) {
        return false;
    }

    @Override
    public boolean noneMatch(Predicate<? super T> predicate) {
        return false;
    }

    @Override
    public Optional<T> findFirst() {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public Optional<T> findAny() {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public Iterator<T> iterator() {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public boolean isParallel() {
        return false;
    }

    @Override
    public Stream<T> sequential() {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public Stream<T> parallel() {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public Stream<T> unordered() {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public Stream<T> onClose(Runnable closeHandler) {
        throw new NotImplementedException("To be implemented.");
    }

    @Override
    public void close() {

    }
}
