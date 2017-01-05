package compsql;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SQLLexer extends Lexer {

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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[]{};
    }

    public SQLLexer() {
    }

    public SQLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }

    public SQLLexer(CharStream input, RecognizerSharedState state) {
        super(input, state);
    }

    @Override
    public String getGrammarFileName() {
        return "SQL.g";
    }

    // $ANTLR start "LETRAS"
    public final void mLETRAS() throws RecognitionException {
        try {
            int _type = LETRAS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL.g:225:8: ( 'letras' )
            // SQL.g:225:10: 'letras'
            {
                match("letras");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "LETRAS"

    // $ANTLR start "NUMEROS"
    public final void mNUMEROS() throws RecognitionException {
        try {
            int _type = NUMEROS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL.g:226:9: ( 'numeros' )
            // SQL.g:226:11: 'numeros'
            {
                match("numeros");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "NUMEROS"

    // $ANTLR start "FECHA"
    public final void mFECHA() throws RecognitionException {
        try {
            int _type = FECHA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL.g:227:7: ( 'fecha' )
            // SQL.g:227:9: 'fecha'
            {
                match("fecha");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "FECHA"

    // $ANTLR start "DECIMAL"
    public final void mDECIMAL() throws RecognitionException {
        try {
            int _type = DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL.g:228:9: ( 'decimal' )
            // SQL.g:228:11: 'decimal'
            {
                match("decimal");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "DECIMAL"

    // $ANTLR start "NOTNULL"
    public final void mNOTNULL() throws RecognitionException {
        try {
            int _type = NOTNULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL.g:229:9: ( 'obligatorio' )
            // SQL.g:229:11: 'obligatorio'
            {
                match("obligatorio");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "NOTNULL"

    // $ANTLR start "NNAUTOINC"
    public final void mNNAUTOINC() throws RecognitionException {
        try {
            int _type = NNAUTOINC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL.g:230:11: ( 'autoincremento' )
            // SQL.g:230:13: 'autoincremento'
            {
                match("autoincremento");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "NNAUTOINC"

    // $ANTLR start "VACIO"
    public final void mVACIO() throws RecognitionException {
        try {
            int _type = VACIO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL.g:231:6: ( 'sin condicion' )
            // SQL.g:231:8: 'sin condicion'
            {
                match("sin condicion");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "VACIO"

    // $ANTLR start "CREAR"
    public final void mCREAR() throws RecognitionException {
        try {
            int _type = CREAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL.g:232:6: ( 'crear' )
            // SQL.g:232:8: 'crear'
            {
                match("crear");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "CREAR"

    // $ANTLR start "DEFINIR"
    public final void mDEFINIR() throws RecognitionException {
        try {
            int _type = DEFINIR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL.g:233:8: ( 'definir' )
            // SQL.g:233:10: 'definir'
            {
                match("definir");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "DEFINIR"

    // $ANTLR start "PA"
    public final void mPA() throws RecognitionException {
        try {
            int _type = PA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL.g:235:3: ( '(' )
            // SQL.g:235:4: '('
            {
                match('(');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PA"

    // $ANTLR start "PC"
    public final void mPC() throws RecognitionException {
        try {
            int _type = PC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL.g:236:3: ( ')' )
            // SQL.g:236:5: ')'
            {
                match(')');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PC"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL.g:238:3: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // SQL.g:238:5: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
                if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
                    input.consume();
                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }
                // SQL.g:238:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
                loop1:
                while (true) {
                    int alt1 = 2;
                    int LA1_0 = input.LA(1);
                    if (((LA1_0 >= '0' && LA1_0 <= '9') || (LA1_0 >= 'A' && LA1_0 <= 'Z') || (LA1_0 >= 'a' && LA1_0 <= 'z'))) {
                        alt1 = 1;
                    }

                    switch (alt1) {
                        case 1: // SQL.g:
                        {
                            if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'Z') || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
                                input.consume();
                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }
                        }
                        break;

                        default:
                            break loop1;
                    }
                }

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "COMA"
    public final void mCOMA() throws RecognitionException {
        try {
            int _type = COMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL.g:240:6: ( ',' )
            // SQL.g:240:8: ','
            {
                match(',');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "COMA"

    // $ANTLR start "TERM"
    public final void mTERM() throws RecognitionException {
        try {
            int _type = TERM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL.g:241:6: ( ';' )
            // SQL.g:241:8: ';'
            {
                match(';');
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "TERM"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL.g:243:4: ( ( ' ' | '\\n' | '\\t' | '\\r' )+ )
            // SQL.g:243:6: ( ' ' | '\\n' | '\\t' | '\\r' )+
            {
                // SQL.g:243:6: ( ' ' | '\\n' | '\\t' | '\\r' )+
                int cnt2 = 0;
                loop2:
                while (true) {
                    int alt2 = 2;
                    int LA2_0 = input.LA(1);
                    if (((LA2_0 >= '\t' && LA2_0 <= '\n') || LA2_0 == '\r' || LA2_0 == ' ')) {
                        alt2 = 1;
                    }

                    switch (alt2) {
                        case 1: // SQL.g:
                        {
                            if ((input.LA(1) >= '\t' && input.LA(1) <= '\n') || input.LA(1) == '\r' || input.LA(1) == ' ') {
                                input.consume();
                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }
                        }
                        break;

                        default:
                            if (cnt2 >= 1) {
                                break loop2;
                            }
                            EarlyExitException eee = new EarlyExitException(2, input);
                            throw eee;
                    }
                    cnt2++;
                }

                _channel = HIDDEN;
            }

            state.type = _type;
            state.channel = _channel;
        } finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    @Override
    public void mTokens() throws RecognitionException {
        // SQL.g:1:8: ( LETRAS | NUMEROS | FECHA | DECIMAL | NOTNULL | NNAUTOINC | VACIO | CREAR | DEFINIR | PA | PC | ID | COMA | TERM | WS )
        int alt3 = 15;
        alt3 = dfa3.predict(input);
        switch (alt3) {
            case 1: // SQL.g:1:10: LETRAS
            {
                mLETRAS();

            }
            break;
            case 2: // SQL.g:1:17: NUMEROS
            {
                mNUMEROS();

            }
            break;
            case 3: // SQL.g:1:25: FECHA
            {
                mFECHA();

            }
            break;
            case 4: // SQL.g:1:31: DECIMAL
            {
                mDECIMAL();

            }
            break;
            case 5: // SQL.g:1:39: NOTNULL
            {
                mNOTNULL();

            }
            break;
            case 6: // SQL.g:1:47: NNAUTOINC
            {
                mNNAUTOINC();

            }
            break;
            case 7: // SQL.g:1:57: VACIO
            {
                mVACIO();

            }
            break;
            case 8: // SQL.g:1:63: CREAR
            {
                mCREAR();

            }
            break;
            case 9: // SQL.g:1:69: DEFINIR
            {
                mDEFINIR();

            }
            break;
            case 10: // SQL.g:1:77: PA
            {
                mPA();

            }
            break;
            case 11: // SQL.g:1:80: PC
            {
                mPC();

            }
            break;
            case 12: // SQL.g:1:83: ID
            {
                mID();

            }
            break;
            case 13: // SQL.g:1:86: COMA
            {
                mCOMA();

            }
            break;
            case 14: // SQL.g:1:91: TERM
            {
                mTERM();

            }
            break;
            case 15: // SQL.g:1:96: WS
            {
                mWS();

            }
            break;

        }
    }

    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS
            = "\1\uffff\10\13\6\uffff\30\13\1\uffff\3\13\1\63\4\13\1\70\1\71\1\13\1\uffff"
            + "\4\13\2\uffff\1\77\1\100\1\101\2\13\3\uffff\6\13\1\112\1\13\1\uffff\2"
            + "\13\1\116\1\uffff";
    static final String DFA3_eofS
            = "\117\uffff";
    static final String DFA3_minS
            = "\1\11\1\145\1\165\2\145\1\142\1\165\1\151\1\162\6\uffff\1\164\1\155\2"
            + "\143\1\154\1\164\1\156\1\145\1\162\1\145\1\150\3\151\1\157\1\40\2\141"
            + "\1\162\1\141\1\155\1\156\1\147\1\151\1\uffff\1\162\1\163\1\157\1\60\1"
            + "\141\1\151\1\141\1\156\2\60\1\163\1\uffff\1\154\1\162\1\164\1\143\2\uffff"
            + "\3\60\1\157\1\162\3\uffff\1\162\1\145\1\151\1\155\1\157\1\145\1\60\1\156"
            + "\1\uffff\1\164\1\157\1\60\1\uffff";
    static final String DFA3_maxS
            = "\1\172\1\145\1\165\2\145\1\142\1\165\1\151\1\162\6\uffff\1\164\1\155\1"
            + "\143\1\146\1\154\1\164\1\156\1\145\1\162\1\145\1\150\3\151\1\157\1\40"
            + "\2\141\1\162\1\141\1\155\1\156\1\147\1\151\1\uffff\1\162\1\163\1\157\1"
            + "\172\1\141\1\151\1\141\1\156\2\172\1\163\1\uffff\1\154\1\162\1\164\1\143"
            + "\2\uffff\3\172\1\157\1\162\3\uffff\1\162\1\145\1\151\1\155\1\157\1\145"
            + "\1\172\1\156\1\uffff\1\164\1\157\1\172\1\uffff";
    static final String DFA3_acceptS
            = "\11\uffff\1\12\1\13\1\14\1\15\1\16\1\17\30\uffff\1\7\13\uffff\1\3\4\uffff"
            + "\1\10\1\1\5\uffff\1\2\1\4\1\11\10\uffff\1\5\3\uffff\1\6";
    static final String DFA3_specialS
            = "\117\uffff}>";
    static final String[] DFA3_transitionS = {
        "\2\16\2\uffff\1\16\22\uffff\1\16\7\uffff\1\11\1\12\2\uffff\1\14\16\uffff"
        + "\1\15\5\uffff\32\13\6\uffff\1\6\1\13\1\10\1\4\1\13\1\3\5\13\1\1\1\13"
        + "\1\2\1\5\3\13\1\7\7\13",
        "\1\17",
        "\1\20",
        "\1\21",
        "\1\22",
        "\1\23",
        "\1\24",
        "\1\25",
        "\1\26",
        "",
        "",
        "",
        "",
        "",
        "",
        "\1\27",
        "\1\30",
        "\1\31",
        "\1\32\2\uffff\1\33",
        "\1\34",
        "\1\35",
        "\1\36",
        "\1\37",
        "\1\40",
        "\1\41",
        "\1\42",
        "\1\43",
        "\1\44",
        "\1\45",
        "\1\46",
        "\1\47",
        "\1\50",
        "\1\51",
        "\1\52",
        "\1\53",
        "\1\54",
        "\1\55",
        "\1\56",
        "\1\57",
        "",
        "\1\60",
        "\1\61",
        "\1\62",
        "\12\13\7\uffff\32\13\6\uffff\32\13",
        "\1\64",
        "\1\65",
        "\1\66",
        "\1\67",
        "\12\13\7\uffff\32\13\6\uffff\32\13",
        "\12\13\7\uffff\32\13\6\uffff\32\13",
        "\1\72",
        "",
        "\1\73",
        "\1\74",
        "\1\75",
        "\1\76",
        "",
        "",
        "\12\13\7\uffff\32\13\6\uffff\32\13",
        "\12\13\7\uffff\32\13\6\uffff\32\13",
        "\12\13\7\uffff\32\13\6\uffff\32\13",
        "\1\102",
        "\1\103",
        "",
        "",
        "",
        "\1\104",
        "\1\105",
        "\1\106",
        "\1\107",
        "\1\110",
        "\1\111",
        "\12\13\7\uffff\32\13\6\uffff\32\13",
        "\1\113",
        "",
        "\1\114",
        "\1\115",
        "\12\13\7\uffff\32\13\6\uffff\32\13",
        ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    protected class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }

        @Override
        public String getDescription() {
            return "1:1: Tokens : ( LETRAS | NUMEROS | FECHA | DECIMAL | NOTNULL | NNAUTOINC | VACIO | CREAR | DEFINIR | PA | PC | ID | COMA | TERM | WS );";
        }
    }

}
