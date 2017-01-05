package compsql;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JTextArea;

@SuppressWarnings("all")
public class SQLParser extends Parser {

    public static final String[] tokenNames = new String[]{
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMA", "CREAR", "DECIMAL", "DEFINIR",
        "FECHA", "ID", "LETRAS", "NNAUTOINC", "NOTNULL", "NUMEROS", "PA", "PC",
        "TERM", "VACIO", "WS"
    };
    public static final int EOF = -1;
    public static final int COMA = 4;
    public static final int CREAR = 5;
    public static final int DECIMAL = 6;
    public static final int DEFINIR = 7;
    public static final int FECHA = 8;
    public static final int ID = 9;
    public static final int LETRAS = 10;
    public static final int NNAUTOINC = 11;
    public static final int NOTNULL = 12;
    public static final int NUMEROS = 13;
    public static final int PA = 14;
    public static final int PC = 15;
    public static final int TERM = 16;
    public static final int VACIO = 17;
    public static final int WS = 18;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[]{};
    }

    // delegators
    public SQLParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }

    public SQLParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    @Override
    public String[] getTokenNames() {
        return SQLParser.tokenNames;
    }

    @Override
    public String getGrammarFileName() {
        return "SQL.g";
    }

    HashMap memory = new HashMap();  	//Hash para saber si se repiten bases de datos
    HashMap hashTablas = new HashMap();
    /*Hash para almacenar el nombre de las tablas y evitar duplicidad, 
	    									cada tabla debe tener un identificador número distinto */
    int contadorTablas = 0;				//este contador permite saber que identificador número de tabla actual se posee
    HashMap hashCampos = new HashMap();
    /*Hash para guardar relación del identificador de una tabla y 
											sus campos  tabla 1 ----> campos n;    tabla 2 ----> campos n;     tabla 3-----> campos n*/
    HashMap hashCamposAux = new HashMap();
    int contadorCampos = 0;
    boolean banderaTabla = false;   		//Esta bandera ayuda a saber si fue exitosa la creación de una tabla
    List<List<String>> dataStructure = new ArrayList<List<String>>();   
    TreeMap<String, String> treeCampos = new TreeMap<>();

    // $ANTLR start "inicio"
    // SQL.g:26:1: inicio : ( database )+ ;
    public final void inicio() throws RecognitionException {
        try {
            // SQL.g:26:7: ( ( database )+ )
            // SQL.g:26:9: ( database )+
            {
                // SQL.g:26:9: ( database )+
                int cnt1 = 0;
                loop1:
                while (true) {
                    int alt1 = 2;
                    int LA1_0 = input.LA(1);
                    if ((LA1_0 == CREAR)) {
                        alt1 = 1;
                    }

                    switch (alt1) {
                        case 1: // SQL.g:26:9: database
                        {
                            pushFollow(FOLLOW_database_in_inicio22);
                            database();
                            state._fsp--;

                        }
                        break;

                        default:
                            if (cnt1 >= 1) {
                                break loop1;
                            }
                            EarlyExitException eee = new EarlyExitException(1, input);
                            throw eee;
                    }
                    cnt1++;
                }

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "inicio"

    // $ANTLR start "database"
    // SQL.g:28:1: database : CREAR t1= ID TERM ( miembro )* ;
    public final void database() throws RecognitionException {
        Token t1 = null;
        Token CREAR1 = null;

        try {
            // SQL.g:28:10: ( CREAR t1= ID TERM ( miembro )* )
            // SQL.g:28:12: CREAR t1= ID TERM ( miembro )*
            {
                CREAR1 = (Token) match(input, CREAR, FOLLOW_CREAR_in_database32);
                t1 = (Token) match(input, ID, FOLLOW_ID_in_database36);

                Integer m = (Integer) memory.get((t1 != null ? t1.getText() : null));
                if (m == null) {
                    if ((CREAR1 != null ? CREAR1.getText() : null).compareTo("crear") == 0) {
                        memory.put((t1 != null ? t1.getText() : null), new Integer(1));
                        salida.append("\n>> Declarando base de datos " + (t1 != null ? t1.getText() : null));
                        archivos.append("\nCREATE DATABASE " + (t1 != null ? t1.getText() : null) + ";\n");
                        archivos.append("\nUSE " + (t1 != null ? t1.getText() : null) + ";\n");
                    }
                } else {
                    salida.append("\n>> Error, la base de datos <" + (t1 != null ? t1.getText() : null) + "> ya existe");
                }

                match(input, TERM, FOLLOW_TERM_in_database40);
                // SQL.g:40:14: ( miembro )*
                loop2:
                while (true) {
                    int alt2 = 2;
                    int LA2_0 = input.LA(1);
                    if ((LA2_0 == DEFINIR)) {
                        alt2 = 1;
                    }

                    switch (alt2) {
                        case 1: // SQL.g:40:14: miembro
                        {
                            pushFollow(FOLLOW_miembro_in_database42);
                            miembro();
                            state._fsp--;

                        }
                        break;

                        default:
                            break loop2;
                    }
                }

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "database"

    // $ANTLR start "miembro"
    // SQL.g:41:1: miembro : tabla ;
    public final void miembro() throws RecognitionException {
        try {
            // SQL.g:41:9: ( tabla )
            // SQL.g:41:11: tabla
            {
                pushFollow(FOLLOW_tabla_in_miembro50);
                tabla();
                state._fsp--;

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "miembro"

    // $ANTLR start "tabla"
    // SQL.g:43:1: tabla : DEFINIR tt1= ID PA campos PC TERM ;
    public final void tabla() throws RecognitionException {
        Token tt1 = null;
        Token DEFINIR2 = null;

        try {
            // SQL.g:43:7: ( DEFINIR tt1= ID PA campos PC TERM )
            // SQL.g:43:9: DEFINIR tt1= ID PA campos PC TERM
            {
                DEFINIR2 = (Token) match(input, DEFINIR, FOLLOW_DEFINIR_in_tabla59);
                tt1 = (Token) match(input, ID, FOLLOW_ID_in_tabla63);

                Integer i = (Integer) hashTablas.get((tt1 != null ? tt1.getText() : null));
                if (i == null) {
                    if ((DEFINIR2 != null ? DEFINIR2.getText() : null).compareTo("definir") == 0) {
                        banderaTabla = true;
                        hashTablas.put(new Integer(contadorTablas), (tt1 != null ? tt1.getText() : null)); 	//guardo en hash para verificar duplicidad
                        dataStructure.add(new ArrayList<String>());				//nueva instancia para una sublista dentro de la lista general dataStructure
                        salida.append("\n>> Declarando tabla " + (tt1 != null ? tt1.getText() : null));
                        archivos.append("\nCREATE TABLE " + (tt1 != null ? tt1.getText() : null) + "(\n");
                        //System.out.println("id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,") ;
                    }
                } else {
                    banderaTabla = false;
                    salida.append("\n>> Error, la tabla <" + (tt1 != null ? tt1.getText() : null) + "> ya existe");
                    //break;  	//¿será correcto detener proceso de creación?
                }

                match(input, PA, FOLLOW_PA_in_tabla66);
                pushFollow(FOLLOW_campos_in_tabla68);
                campos();
                state._fsp--;

                match(input, PC, FOLLOW_PC_in_tabla70);
                match(input, TERM, FOLLOW_TERM_in_tabla72);
            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "tabla"

    // $ANTLR start "campos"
    // SQL.g:61:1: campos : tc1= ID ttipo1= tipo (tcon1= condicion )* ( COMA tc2= ID ttipo2= tipo (tcon2= condicion )* )* ;
    public final void campos() throws RecognitionException {
        Token tc1 = null;
        Token tc2 = null;
        ParserRuleReturnScope ttipo1 = null;
        ParserRuleReturnScope tcon1 = null;
        ParserRuleReturnScope ttipo2 = null;
        ParserRuleReturnScope tcon2 = null;

        try {
            // SQL.g:61:8: (tc1= ID ttipo1= tipo (tcon1= condicion )* ( COMA tc2= ID ttipo2= tipo (tcon2= condicion )* )* )
            // SQL.g:61:10: tc1= ID ttipo1= tipo (tcon1= condicion )* ( COMA tc2= ID ttipo2= tipo (tcon2= condicion )* )*
            {
                tc1 = (Token) match(input, ID, FOLLOW_ID_in_campos83);
                pushFollow(FOLLOW_tipo_in_campos87);
                ttipo1 = tipo();
                state._fsp--;

                // SQL.g:61:34: (tcon1= condicion )*
                loop3:
                while (true) {
                    int alt3 = 2;
                    int LA3_0 = input.LA(1);
                    if (((LA3_0 >= NNAUTOINC && LA3_0 <= NOTNULL) || LA3_0 == VACIO)) {
                        alt3 = 1;
                    }

                    switch (alt3) {
                        case 1: // SQL.g:61:34: tcon1= condicion
                        {
                            pushFollow(FOLLOW_condicion_in_campos91);
                            tcon1 = condicion();
                            state._fsp--;

                        }
                        break;

                        default:
                            break loop3;
                    }
                }

                Integer j = (Integer) hashCamposAux.get((tc1 != null ? tc1.getText() : null));
                if (j == null) {
                    hashCamposAux.put((tc1 != null ? tc1.getText() : null), new Integer(3));			//estos hashes me ayudan a evitar campos repetidos
                    hashCampos.put((tc1 != null ? tc1.getText() : null), contadorTablas);
                    treeCampos.put((contadorTablas + "-" + contadorCampos), (tc1 != null ? tc1.getText() : null));
                    dataStructure.get(contadorTablas).add("" + (tc1 != null ? tc1.getText() : null));	//a partir de que genero una sublista, contadorTablas me permite saber 
                    //la tabla actual e ir ingresando todos sus respectivos campos
                    salida.append("\n>> Declarando atributo " + (tc1 != null ? tc1.getText() : null) + " de tipo " + (ttipo1 != null ? input.toString(ttipo1.start, ttipo1.stop) : null));

                    if ((ttipo1 != null ? input.toString(ttipo1.start, ttipo1.stop) : null).compareTo("letras") == 0) {
                        archivos.append((tc1 != null ? tc1.getText() : null) + " VARCHAR(60) ");
                        if ((tcon1 != null ? input.toString(tcon1.start, tcon1.stop) : null).compareTo("obligatorio") == 0) {
                            archivos.append("NOT NULL");
                        } else if ((tcon1 != null ? input.toString(tcon1.start, tcon1.stop) : null).compareTo("obligatorio autoincremento") == 0) {
                            archivos.append("NOT NULL AUTO_INCREMENT");
                        } else if ((tcon1 != null ? input.toString(tcon1.start, tcon1.stop) : null).compareTo("autoincremento") == 0) {
                            archivos.append("NOT NULL AUTO_INCREMENT");
                        } else if ((tcon1 != null ? input.toString(tcon1.start, tcon1.stop) : null).compareTo("sin condicion") == 0) {
                            archivos.append("");
                        }
                    } else if ((ttipo1 != null ? input.toString(ttipo1.start, ttipo1.stop) : null).compareTo("numeros") == 0) {
                        archivos.append((tc1 != null ? tc1.getText() : null) + " INT ");
                        if ((tcon1 != null ? input.toString(tcon1.start, tcon1.stop) : null).compareTo("obligatorio") == 0) {
                            archivos.append("NOT NULL");
                        } else if ((tcon1 != null ? input.toString(tcon1.start, tcon1.stop) : null).compareTo("obligatorio autoincremento") == 0) {
                            archivos.append("NOT NULL AUTO_INCREMENT");
                        } else if ((tcon1 != null ? input.toString(tcon1.start, tcon1.stop) : null).compareTo("autoincremento") == 0) {
                            archivos.append("NOT NULL AUTO_INCREMENT");
                        } else if ((tcon1 != null ? input.toString(tcon1.start, tcon1.stop) : null).compareTo("sin condicion") == 0) {
                            archivos.append("");
                        }
                    } else if ((ttipo1 != null ? input.toString(ttipo1.start, ttipo1.stop) : null).compareTo("fecha") == 0) {
                        archivos.append((tc1 != null ? tc1.getText() : null) + " DATE ");
                        if ((tcon1 != null ? input.toString(tcon1.start, tcon1.stop) : null).compareTo("obligatorio") == 0) {
                            archivos.append("NOT NULL");
                        } else if ((tcon1 != null ? input.toString(tcon1.start, tcon1.stop) : null).compareTo("obligatorio autoincremento") == 0) {
                            archivos.append("NOT NULL AUTO_INCREMENT");
                        } else if ((tcon1 != null ? input.toString(tcon1.start, tcon1.stop) : null).compareTo("autoincremento") == 0) {
                            archivos.append("NOT NULL AUTO_INCREMENT");
                        } else if ((tcon1 != null ? input.toString(tcon1.start, tcon1.stop) : null).compareTo("sin condicion") == 0) {
                            archivos.append("");
                        }
                    } else if ((ttipo1 != null ? input.toString(ttipo1.start, ttipo1.stop) : null).compareTo("decimal") == 0) {
                        archivos.append((tc1 != null ? tc1.getText() : null) + " DOUBLE ");
                        if ((tcon1 != null ? input.toString(tcon1.start, tcon1.stop) : null).compareTo("obligatorio") == 0) {
                            archivos.append("NOT NULL");
                        } else if ((tcon1 != null ? input.toString(tcon1.start, tcon1.stop) : null).compareTo("obligatorio autoincremento") == 0) {
                            archivos.append("NOT NULL AUTO_INCREMENT");
                        } else if ((tcon1 != null ? input.toString(tcon1.start, tcon1.stop) : null).compareTo("autoincremento") == 0) {
                            archivos.append("NOT NULL AUTO_INCREMENT");
                        } else if ((tcon1 != null ? input.toString(tcon1.start, tcon1.stop) : null).compareTo("sin condicion") == 0) {
                            archivos.append("");
                        }
                    }

                } else {
                    salida.append("\n>> Error, el atributo <" + (tc1 != null ? tc1.getText() : null) + "> ya existe");
                }

                // SQL.g:131:7: ( COMA tc2= ID ttipo2= tipo (tcon2= condicion )* )*
                loop5:
                while (true) {
                    int alt5 = 2;
                    int LA5_0 = input.LA(1);
                    if ((LA5_0 == COMA)) {
                        alt5 = 1;
                    }

                    switch (alt5) {
                        case 1: // SQL.g:131:8: COMA tc2= ID ttipo2= tipo (tcon2= condicion )*
                        {
                            match(input, COMA, FOLLOW_COMA_in_campos97);
                            archivos.append(",\n");
                            tc2 = (Token) match(input, ID, FOLLOW_ID_in_campos108);
                            pushFollow(FOLLOW_tipo_in_campos112);
                            ttipo2 = tipo();
                            state._fsp--;

                            // SQL.g:132:30: (tcon2= condicion )*
                            loop4:
                            while (true) {
                                int alt4 = 2;
                                int LA4_0 = input.LA(1);
                                if (((LA4_0 >= NNAUTOINC && LA4_0 <= NOTNULL) || LA4_0 == VACIO)) {
                                    alt4 = 1;
                                }

                                switch (alt4) {
                                    case 1: // SQL.g:132:30: tcon2= condicion
                                    {
                                        pushFollow(FOLLOW_condicion_in_campos116);
                                        tcon2 = condicion();
                                        state._fsp--;

                                    }
                                    break;

                                    default:
                                        break loop4;
                                }
                            }

                            Integer k = (Integer) hashCamposAux.get((tc2 != null ? tc2.getText() : null));
                            if (k == null) {
                                contadorCampos++;
                                hashCamposAux.put((tc2 != null ? tc2.getText() : null), new Integer(3));			//estos hashes me ayudan a evitar campos repetidos
                                hashCampos.put(contadorTablas, (tc2 != null ? tc2.getText() : null));
                                treeCampos.put((contadorTablas + "-" + contadorCampos), (tc2 != null ? tc2.getText() : null));
                                dataStructure.get(contadorTablas).add("" + (tc2 != null ? tc2.getText() : null));	//a partir de que genero una sublista, contadorTablas me permite saber 
                                //la tabla actual e ir ingresando todos sus respectivos campos
                                salida.append("\n>> Declarando atributo " + (tc2 != null ? tc2.getText() : null) + " de tipo " + (ttipo2 != null ? input.toString(ttipo2.start, ttipo2.stop) : null));

                                if ((ttipo2 != null ? input.toString(ttipo2.start, ttipo2.stop) : null).compareTo("letras") == 0) {
                                    archivos.append((tc2 != null ? tc2.getText() : null) + " VARCHAR(60) ");
                                    if ((tcon2 != null ? input.toString(tcon2.start, tcon2.stop) : null).compareTo("obligatorio") == 0) {
                                        archivos.append("NOT NULL");
                                    } else if ((tcon2 != null ? input.toString(tcon2.start, tcon2.stop) : null).compareTo("obligatorio autoincremento") == 0) {
                                        archivos.append("NOT NULL AUTO_INCREMENT");
                                    } else if ((tcon2 != null ? input.toString(tcon2.start, tcon2.stop) : null).compareTo("autoincremento") == 0) {
                                        archivos.append("NOT NULL AUTO_INCREMENT");
                                    } else if ((tcon2 != null ? input.toString(tcon2.start, tcon2.stop) : null).compareTo("sin condicion") == 0) {
                                        archivos.append("");
                                    }
                                } else if ((ttipo2 != null ? input.toString(ttipo2.start, ttipo2.stop) : null).compareTo("numeros") == 0) {
                                    archivos.append((tc2 != null ? tc2.getText() : null) + " INT ");
                                    if ((tcon2 != null ? input.toString(tcon2.start, tcon2.stop) : null).compareTo("obligatorio") == 0) {
                                        archivos.append("NOT NULL");
                                    } else if ((tcon2 != null ? input.toString(tcon2.start, tcon2.stop) : null).compareTo("obligatorio autoincremento") == 0) {
                                        archivos.append("NOT NULL AUTO_INCREMENT");
                                    } else if ((tcon2 != null ? input.toString(tcon2.start, tcon2.stop) : null).compareTo("autoincremento") == 0) {
                                        archivos.append("NOT NULL AUTO_INCREMENT");
                                    } else if ((tcon2 != null ? input.toString(tcon2.start, tcon2.stop) : null).compareTo("sin condicion") == 0) {
                                        archivos.append("");
                                    }
                                } else if ((ttipo2 != null ? input.toString(ttipo2.start, ttipo2.stop) : null).compareTo("fecha") == 0) {
                                    archivos.append((tc2 != null ? tc2.getText() : null) + " DATE ");
                                    if ((tcon2 != null ? input.toString(tcon2.start, tcon2.stop) : null).compareTo("obligatorio") == 0) {
                                        archivos.append("NOT NULL");
                                    } else if ((tcon2 != null ? input.toString(tcon2.start, tcon2.stop) : null).compareTo("obligatorio autoincremento") == 0) {
                                        archivos.append("NOT NULL AUTO_INCREMENT");
                                    } else if ((tcon2 != null ? input.toString(tcon2.start, tcon2.stop) : null).compareTo("autoincremento") == 0) {
                                        archivos.append("NOT NULL AUTO_INCREMENT");
                                    } else if ((tcon2 != null ? input.toString(tcon2.start, tcon2.stop) : null).compareTo("sin condicion") == 0) {
                                        archivos.append("");
                                    }
                                } else if ((ttipo2 != null ? input.toString(ttipo2.start, ttipo2.stop) : null).compareTo("decimal") == 0) {
                                    archivos.append((tc2 != null ? tc2.getText() : null) + " DOUBLE ");
                                    if ((tcon2 != null ? input.toString(tcon2.start, tcon2.stop) : null).compareTo("obligatorio") == 0) {
                                        archivos.append("NOT NULL");
                                    } else if ((tcon2 != null ? input.toString(tcon2.start, tcon2.stop) : null).compareTo("obligatorio autoincremento") == 0) {
                                        archivos.append("NOT NULL AUTO_INCREMENT");
                                    } else if ((tcon2 != null ? input.toString(tcon2.start, tcon2.stop) : null).compareTo("autoincremento") == 0) {
                                        archivos.append("NOT NULL AUTO_INCREMENT");
                                    } else if ((tcon2 != null ? input.toString(tcon2.start, tcon2.stop) : null).compareTo("sin condicion") == 0) {
                                       archivos.append("");
                                    }
                                }
                            } else {
                                salida.append("\n>> Error, el atributo <" + (tc2 != null ? tc2.getText() : null) + "> ya existe");
                            }

                        }
                        break;

                        default:
                            break loop5;
                    }
                }

                contadorCampos = 0;
                contadorTablas++; 			//incremento el identificador de la tabla
                hashCamposAux.clear();		//borra el contenido de este hash auxiliar
                //recorre el hash de campos y ver su relacion con tablas

                /*System.out.println("\n\nCampos de Tabla 1");
			        				System.out.println("-------------------------");
			        				for (int iter = 0; iter <= dataStructure.get(0).size() - 1; iter++) {
			            				System.out.println(">>"+ dataStructure.get(0).get(iter));
			        				}*/
                System.out.println("\n\nContenido de la lista de listas: " + dataStructure);
                System.out.println("\n\nContenido del tree map " + treeCampos);
                System.out.println("\nContenido de bases de datos: " + memory);
                System.out.println("Contenido de indices y nombres de tablas" + hashTablas);

                archivos.append(");\n\n");

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "campos"

    JTextArea salida;
    void setSalida(JTextArea taSalida) {
        salida = taSalida;
    }

    JTextArea archivos;
    void setArchivo(JTextArea taAuxiliarArchivos) {
        archivos = taAuxiliarArchivos;
    }

    public HashMap getHashTablas() {
        return hashTablas;
    }
    
    public List<List<String>> getDataStructure() {
        return dataStructure;
    }

    public TreeMap<String, String> getTreeCampos() {
        return treeCampos;
    }

    public static class tipo_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "tipo"
    // SQL.g:221:1: tipo : ( LETRAS | NUMEROS | FECHA | DECIMAL );
    public final SQLParser.tipo_return tipo() throws RecognitionException {
        SQLParser.tipo_return retval = new SQLParser.tipo_return();
        retval.start = input.LT(1);

        try {
            // SQL.g:221:6: ( LETRAS | NUMEROS | FECHA | DECIMAL )
            // SQL.g:
            {
                if (input.LA(1) == DECIMAL || input.LA(1) == FECHA || input.LA(1) == LETRAS || input.LA(1) == NUMEROS) {
                    input.consume();
                    state.errorRecovery = false;
                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    throw mse;
                }
            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tipo"

    public static class condicion_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "condicion"
    // SQL.g:223:1: condicion : ( NOTNULL | NNAUTOINC | VACIO );
    public final SQLParser.condicion_return condicion() throws RecognitionException {
        SQLParser.condicion_return retval = new SQLParser.condicion_return();
        retval.start = input.LT(1);

        try {
            // SQL.g:223:11: ( NOTNULL | NNAUTOINC | VACIO )
            // SQL.g:
            {
                if ((input.LA(1) >= NNAUTOINC && input.LA(1) <= NOTNULL) || input.LA(1) == VACIO) {
                    input.consume();
                    state.errorRecovery = false;
                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    throw mse;
                }
            }

            retval.stop = input.LT(-1);

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "condicion"

    // Delegated rules
    public static final BitSet FOLLOW_database_in_inicio22 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_CREAR_in_database32 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_database36 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_TERM_in_database40 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_miembro_in_database42 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_tabla_in_miembro50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINIR_in_tabla59 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_tabla63 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_PA_in_tabla66 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_campos_in_tabla68 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_PC_in_tabla70 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_TERM_in_tabla72 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_campos83 = new BitSet(new long[]{0x0000000000002540L});
    public static final BitSet FOLLOW_tipo_in_campos87 = new BitSet(new long[]{0x0000000000021812L});
    public static final BitSet FOLLOW_condicion_in_campos91 = new BitSet(new long[]{0x0000000000021812L});
    public static final BitSet FOLLOW_COMA_in_campos97 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_campos108 = new BitSet(new long[]{0x0000000000002540L});
    public static final BitSet FOLLOW_tipo_in_campos112 = new BitSet(new long[]{0x0000000000021812L});
    public static final BitSet FOLLOW_condicion_in_campos116 = new BitSet(new long[]{0x0000000000021812L});
}
