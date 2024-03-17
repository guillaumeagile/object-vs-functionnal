package org.example.imsa;

import java.util.Optional;

public record EntierStrictementPositif(Integer valeur) {

//   private EntierStrictementPositif(Integer valeur){
//       this(valeur);
//   }
    public static Optional< EntierStrictementPositif> Build(Integer valeurInitial) {
        if (valeurInitial <1)  return Optional.empty();
        return   Optional.of( new EntierStrictementPositif(valeurInitial));
    }
}
