enum Type{NORMAL,FEU,EAU,ELECTRIQUE,PLANTE,VOL,COMBAT,SOL,ROCHE,POISON,INSECTE,SPECTRE,PSY,DRAGON,GLACE;

    public float compare(Type att, Type def){
        switch (att){
            //TYPE NORMAL "MMMH..... JUST AVERAGE"
            case NORMAL:{
                switch (def){
                    case ROCHE:{
                        return 0.5f;
                    }break;
                    case SPECTRE:{
                        return 0.0f;
                    }break;
                }
            }break;
            //TYPE FEU "THIS POKEMON IS ON FIIIIIIIIIRE!!"
            case FEU:{
                switch (def){
                    case PLANTE:
                    case INSECTE:
                    case GLACE:
                        return 2.0f;
                    break;
                    case FEU:
                    case EAU:
                    case ROCHE:
                    case DRAGON:
                        return 0.5f;
                    break;
                }
            }break;
            //TYPE EAU "REALESE THE KRAKEN!!"
            case EAU:{
                switch (def){
                    case FEU:
                    case ROCHE:
                    case SOL:
                        return 2.0f;
                    break;
                    case EAU:
                    case DRAGON:
                    case PLANTE:
                        return 0.5f;
                    break;
                }
            }break;
            //TYPE ELECTRIQUE "BZZZZT"
            case ELECTRIQUE:{
                switch (def){
                    case EAU:
                    case VOL:
                        return 2.0f;
                    break;
                    case PLANTE:
                    case ELECTRIQUE:
                    case DRAGON:
                        return 0.5f;
                    break;
                    case SOL:
                        return 0.0f;
                    break;
                }
            }break;
            // TYPE PLANTE "ESPECE D'ENCULEUR D'ARBRES"
            case PLANTE: {
                switch (def) {
                    case EAU:
                    case SOL:
                    case ROCHE:
                        return 2.0f;
                    break;
                    case FEU:
                    case PLANTE:
                    case POISON:
                    case DRAGON:
                    case VOL:
                    case INSECTE:
                        return 0.5f;
                    break;
                }
            }break;
            //TYPE VOL "J'AIMERAI MIEUX ETRE UN OISEAU!!!"
            case VOL:{
                switch(def){
                    case PLANTE:
                    case COMBAT:
                    case INSECTE:
                        return 2.0f;
                    break;
                    case ELECTRIQUE:
                    case ROCHE:
                        return 0.5f;
                    break;

                }
            }break;
            //TYPE COMBAT "THE EYE OF THE TIGER!!"
            case COMBAT:{
                switch (def){
                    case NORMAL:
                    case ROCHE:
                    case GLACE:
                        return 2.0f;
                    break;
                    case INSECTE:
                    case VOL:
                    case POISON:
                    case PSY:
                        return 0.5f;
                    break;
                }
            }break;
            //TYPE SOL "LA TERRE EST BASSE"
        }




    }


}