package hu.nye.kovacssebestyen.progkor.szemuvegek.data.repository;

import java.util.List;

/**
 * A repozitorihoz tervezett függvények interface-e.
 *
 * @param <T> Bekéri egy szemüveg adatait
 *
 * @param <I> Bekéri az adott szemüveg id-jét
 */
public interface Repository<T, I> {

    T save(T item);

    T getById(I id);

    List<T> getAll();

    T update(T item);

    void deleteById(I id);
}
