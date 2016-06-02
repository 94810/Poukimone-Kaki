enum Type{NORMAL,FEU,EAU,ELECTRIQUE,PLANTE,VOL,COMBAT,SOL,ROCHE,POISON,INSECTE,SPECTRE,PSY,DRAGON,GLACE;

    public float compare(Type att, Type def){
        switch (att){
            //TYPE NORMAL
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
            //TYPE FEU
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
            //TYPE EAU
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
            //TYPE ELECTRIQUE
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
            // TYPE PLANTE
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
                        retrun 0.5f;
                        break;
                }
            }break;

            case



                }



            }

        }




    }


}