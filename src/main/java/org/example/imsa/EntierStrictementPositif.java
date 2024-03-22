package org.example.imsa;

import io.vavr.control.Option;

import java.util.Optional;

public record EntierStrictementPositif(Integer valeur) {

//   private EntierStrictementPositif(Integer valeur){
//       this(valeur);
//   }
    public static Optional< EntierStrictementPositif> Build(Integer valeurInitial) {
        if (valeurInitial <1)  return Optional.empty();
        return   Optional.of( new EntierStrictementPositif(valeurInitial));
    }

    public static Option< EntierStrictementPositif> Build2(Integer valeurInitial) {
        if (valeurInitial <1)  return Option.none();
        return   Option.of( new EntierStrictementPositif(valeurInitial));
    }
}
