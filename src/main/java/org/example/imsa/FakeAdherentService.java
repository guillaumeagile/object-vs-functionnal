package org.example.imsa;

import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class FakeAdherentService {

    private final ArrayList<Adherent> list;

    public  FakeAdherentService( ArrayList<Adherent> list ) {
        this.list = list;
    }


    public  Option<List<Adherent>> trouverAdherents3(Option< EntierStrictementPositif> nbMax) {

        List<Adherent> emptyList = new ArrayList<Adherent>();
        var res =  nbMax
                .map(valeurMax -> list.stream()
                        .limit(valeurMax.valeur())
                        .collect(Collectors.toList()));

        return res.orElse( Option.of(list) );

    }



    public List<Adherent> trouverAdherents2( Either< String, Optional< EntierStrictementPositif>> entree) {


        Optional<List<Adherent>> res2 = entree.fold(
                _ -> Optional.of(new ArrayList<>(list)),
                nbMax -> nbMax
                        .map(valeurMax -> list.stream()
                                .limit(valeurMax.valeur())
                                .collect(Collectors.toList()))
                );

        return res2.orElse(new ArrayList<Adherent>());
    }
}
