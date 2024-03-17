package org.example.imsa;

import io.vavr.control.Either;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class FakeAdherentService {

    private final ArrayList<Adherent> list;

    public  FakeAdherentService( ArrayList<Adherent> list ) {
        this.list = list;
    }
    public List<Adherent> trouverAdherents(Optional< EntierStrictementPositif> nbMax) {

       var res =  nbMax
               .map(valeurMax -> list.stream()
                       .limit(valeurMax.valeur())
                       .collect(Collectors.toList()));

        return res.orElse(new ArrayList<Adherent>());

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
