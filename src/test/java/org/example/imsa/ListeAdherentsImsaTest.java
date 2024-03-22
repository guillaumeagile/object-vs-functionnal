package org.example.imsa;

import io.vavr.control.Either;
import io.vavr.control.Option;
import org.example.imsa.Adherent;
import org.example.imsa.EntierStrictementPositif;
import org.example.imsa.FakeAdherentService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ListeAdherentsImsaTest {

    @Test
    void EntierStrictementPositif_1() {
        var sut =  EntierStrictementPositif.Build(1);

        sut.map( v -> assertThat(v).isEqualTo( new EntierStrictementPositif(1)) );
    }

    @Test
    void EntierStrictementPositif_0() {
        var sut = EntierStrictementPositif.Build(0);

        assertThat( sut).isEmpty();
    }

    @Test
    void trouverAdherentsZeroAdherents() {

        var service = new FakeAdherentService(new ArrayList<>() );
       var result = service.trouverAdherents3(Option.none());

        assertThat( result).isNotEmpty();  // the monad is not empty (is some)
        assertThat( result.get()).isEmpty(); // but its content is empty
    }

    @Test
    void TrouverZeroQuandIlYaPlusQueZero() {

        var liste = new ArrayList<Adherent>();
        liste.add(new Adherent("0001", "gaston", 18));
        var service =
                new FakeAdherentService(liste);
        var result = service.trouverAdherents3(Option.none());

        assertThat( result).isNotEmpty();  // the monad is not empty (is some)
        assertThat( result.get()).isNotEmpty(); //  its content is not empty either
    }

    @Test
    void renameMe() {

        var liste = new ArrayList<Adherent>();
        liste.add(new Adherent("0001", "gaston", 18));
        var service =
                new FakeAdherentService(liste);
        var result = service.trouverAdherents3(
                EntierStrictementPositif.Build2(0));

        assertThat( result).isNotEmpty();
        assertThat( result.get()).isNotEmpty(); // and its content is not empty

    }

    @Test
    void pasDeFiltre() {

        var liste = new ArrayList<Adherent>();
        liste.add(new Adherent("0001", "gaston", 18));
        var service =
                new FakeAdherentService(liste);
        var result = service.trouverAdherents2 ( Either.left("pas de filter"));

        assertThat( result).isNotEmpty();
    }

    @Test
    void unFiltre() {

        var liste = new ArrayList<Adherent>();
        liste.add(new Adherent("0001", "gaston", 18));
        var service =
                new FakeAdherentService(liste);
        var result = service.trouverAdherents2 (
                Either.right(
                        EntierStrictementPositif.Build(0)
        ));
        assertThat( result).isEmpty();
    }

    @Test
    void unFiltreAvec5() {

        var liste = new ArrayList<Adherent>();
        liste.add(new Adherent("0001", "gaston", 18));
        liste.add(new Adherent("0002", "lagaffe", 18));
        var service =
                new FakeAdherentService(liste);
        var result = service.trouverAdherents2 (
                Either.right(
                        EntierStrictementPositif.Build(1)
                ));

        assertThat( result).hasSize(1);
    }

    @Test
    void pasDefiltreEt2ElemsEnEntree() {

        var liste = new ArrayList<Adherent>();
        liste.add(new Adherent("0001", "gaston", 18));
        liste.add(new Adherent("0002", "lagaffe", 18));
        var service =
                new FakeAdherentService(liste);
        var result = service.trouverAdherents2 (
                Either.left(
                       "pas de filtre, merci"
                ));

        assertThat( result).hasSize(2);
    }
}
