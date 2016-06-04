public enum Type{NORMAL,FEU,EAU,ELECTRIQUE,PLANTE,VOL,COMBAT,SOL,ROCHE,POISON,INSECTE,SPECTRE,PSY,DRAGON,GLACE;

    public static float compare(Type att, Type def){

        float res=1.0f;

        switch (att){
            //TYPE NORMAL "MMMH..... JUST AVERAGE"
            case NORMAL:
                switch (def){
                    case ROCHE:
                        res= 0.5f;
                    break;
                    case SPECTRE:
                        res= 0.0f;
                    break;
                }
            break;
            //TYPE FEU "THIS POKEMON IS ON FIIIIIIIIIRE!!"
            case FEU:
                switch (def){
                    case PLANTE:
                    case INSECTE:
                    case GLACE:
                        res= 2.0f;
                    break;
                    case FEU:
                    case EAU:
                    case ROCHE:
                    case DRAGON:
                        res= 0.5f;
                    break;
                }
            break;
            //TYPE EAU "REALESE THE KRAKEN!!"
            case EAU:
                switch (def){
                    case FEU:
                    case ROCHE:
                    case SOL:
                        res= 2.0f;
                    break;
                    case EAU:
                    case DRAGON:
                    case PLANTE:
                        res= 0.5f;
                    break;
                }
            break;
            //TYPE ELECTRIQUE "BZZZZT"
            case ELECTRIQUE:
                switch (def){
                    case EAU:
                    case VOL:
                        res= 2.0f;
                    break;
                    case PLANTE:
                    case ELECTRIQUE:
                    case DRAGON:
                        res= 0.5f;
                    break;
                    case SOL:
                        res= 0.0f;
                    break;
                }
            break;
            // TYPE PLANTE "ESPECE D'ENCULEUR D'ARBRES"
            case PLANTE:
                switch (def) {
                    case EAU:
                    case SOL:
                    case ROCHE:
                        res= 2.0f;
                    break;
                    case FEU:
                    case PLANTE:
                    case POISON:
                    case DRAGON:
                    case VOL:
                    case INSECTE:
                        res= 0.5f;
                    break;
                }
            break;
            //TYPE VOL "J'AIMERAI MIEUX ETRE UN OISEAU!!!"
            case VOL:
                switch(def){
                    case PLANTE:
                    case COMBAT:
                    case INSECTE:
                        res= 2.0f;
                    break;
                    case ELECTRIQUE:
                    case ROCHE:
                        res= 0.5f;
                    break;

                }
            break;
            //TYPE COMBAT "THE EYE OF THE TIGER!!"
            case COMBAT:
                switch (def){
                    case NORMAL:
                    case ROCHE:
                    case GLACE:
                        res= 2.0f;
                    break;
                    case INSECTE:
                    case VOL:
                    case POISON:
                    case PSY:
                        res= 0.5f;
                    break;
                }
            break;
            //TYPE SOL "LA TERRE EST BASSE"
            case SOL:
                switch (def) {
                    case ELECTRIQUE:
                    case POISON:
                    case FEU:
                    case ROCHE:
                        res= 2.0f;
                    break;
                    case INSECTE:
                    case PLANTE:
                        res= 0.5f;
                    break;
                }
            break;
            //TYPE ROCHE "PIERRE QUI ROULE N'AMASSE PAS MOUSSE"
            case ROCHE:
                switch (def) {
                    case FEU:
                    case VOL:
                    case GLACE:
                    case INSECTE:
                        res= 2.0f;
                    break;
                    case SOL:
                    case COMBAT:
                        res= 0.5f;
                    break;
                }
            break;
            // TYPE POISON "WITH THE TASTE OF YOUR LIPS, I'M FALLING DOWN... YOU'RE TOXIC, I'M FALLING UNDER"
            case POISON:
                switch (def) {
                    case PLANTE:
                    case INSECTE:
                        res= 2.0f;
                    break;
                    case POISON:
                    case ROCHE:
                    case SOL:
                    case SPECTRE:
                        res= 0.5f;
                    break;
                }
            break;
            //TYPE INSECTE "SALUT C'EST MOI COXI, JSUIS UNE COXI, PAS UN FOURMI"
            case INSECTE:
                switch (def){
                    case PLANTE:
                    case POISON:
                    case PSY:
                        res= 2.0f;
                    break;
                    case COMBAT:
                    case FEU:
                    case SPECTRE:
                    case VOL:
                        res= 0.5f;
                    break;
                }
            break;
            //TYPE SPECTRE "SPOOLY SCARY SKELETONS"
            case SPECTRE:
                switch(def){
                    case SPECTRE:
                        res= 2.0f;
                    break;
                    case NORMAL:
                    case PSY:
                        res= 0.0f;
                    break;
                }
            break;
            // TYPE PSY "WHERE IS MY MIND..."
            case PSY:
                switch (def){
                    case COMBAT:
                    case POISON:
                        res= 2.0f;
                    break;
                    case PSY:
                        res= 0.5f;
                    break;
                }
            break;
            //TYPE DRAGON "THROUGH THE FIRE AND FLAMES, WE CARY OOOOOOOON!!!!!"
            case DRAGON:
                switch (def){
                    case DRAGON:
                        res= 2.0f;
                    break;
                }
            break;
            //TYPE GLACE "LIBEREEEEE DELIVREEEEE, JE NE MENTIRAIS PLUS JAMAIS!!!
            case GLACE:
                switch (def){
                    case SOL:
                    case VOL:
                    case PLANTE:
                    case DRAGON:
                        res= 2.0f;
                    break;
                    case FEU:
                    case EAU:
                    case GLACE:
                        res= 0.5f;
                    break;
                }
            break;
        }
       return  res;
    }
}


