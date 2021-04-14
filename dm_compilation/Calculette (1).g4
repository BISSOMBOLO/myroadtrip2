grammar Calculette;

@members {
    private TablesSymboles tablesSymboles = new TablesSymboles();
	private int _cur_label = 1;
	 private String getNewLabel() { return "B" +(_cur_label++); }
}

start: calcul EOF;
calcul returns[ String code ]
	@init { $code = new String(); }
	@after { System.out.println($code); }
    :

		NEWLINE*
        (declassigne { $code += $declassigne.code; } | decl { $code += $decl.code; })*
	    NEWLINE*
        (instruction { $code += $instruction.code; })*
        NEWLINE*
		{ $code += "  HALT\n"; }
		EOF
    ;
    
instruction returns[ String code ]
	: express finInstruction { $code = $express.code; }
	| assigne finInstruction { $code = $assigne.code; }
    | instructionSortie finInstruction {$code = $instructionSortie.code;}
    | instructionEntree finInstruction {$code = $instructionEntree.code;}
	| finInstruction { $code=""; }
	| boucle { $code = $boucle.code;}
	;


instructionEntree  returns [String code]
    : READ '('IDENTIFIANT')'{
      AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
      $code = "READ \n"+ " STOREG " +at.adresse+"\n";};


instructionSortie  returns [String code]
  : WRITE '('express')'
        {
           $code = $express.code+ "WRITE \n " + "POP\n";
        }
    ;

express returns[ String code ]
	: '(' express ')' { $code = $express.code; }
	| a = express op = (MUL|DIV) b = express
		{
			$code = $a.code + $b.code;

			if ($op.text.equals("*")) {
				$code += "  MUL\n";
			}
			else {
				$code += "  DIV\n";
			}
		}
	| a = express op = (ADD|SUB) b = express
		{
			$code = $a.code + $b.code;

			if ($op.text.equals("+")) {
				$code += "  ADD\n";
			}
			else {
				$code += "  SUB\n";
			}
		}
	| SUB ENTIER { $code = "  PUSHI -" + $ENTIER.text + "\n"; }
	| ENTIER { $code = "  PUSHI " + $ENTIER.text + "\n"; }
	| IDENTIFIANT
		{
			AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);

			$code = "  PUSHG " + at.adresse + "\n";
		}
  ;

declassigne returns [ String code ]
	: TYPE IDENTIFIANT '=' express finInstruction
		 {
       tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
       AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
        $code = "PUSHI 0\n"+$express.code+ "STOREG "+at.adresse+"\n";
     }
    ;

decl returns [ String code ]
    : TYPE IDENTIFIANT finInstruction
	{

      tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
      if($TYPE.text.equals("int")){
        $code = "PUSHI 0"+"\n";
      }else {
        $code = "PUSHF 0.0"+"\n";
      }
    }
    ;

assigne returns [ String code ]
    : IDENTIFIANT '=' express
        {
            $code = $express.code;

			AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);

			$code += "  STOREG " + at.adresse + "\n";
        };
		 
condition returns [ String code ]
   : 'true' { $code = "PUSHI 1\n";}
   | 'false' { $code =  "PUSHI 0\n";}
   ;	  

boucle returns[ String code ]
    :WHILE '(' condition ')' instruction {
	 String debutWhile = getNewLabel();
	 String finWhile = getNewLabel();
	 $code = "LABEL "+ debutWhile +"\n";
	 $code +=  $condition.code;
	 $code += " JUMPF "+ finWhile +"\n";
	 $code +=  $instruction.code;
	 $code+= " JUMP "+ debutWhile +"\n";
	 $code +=  " LABEL "+ finWhile +"\n";
	};
	

//lexer
finInstruction : (NEWLINE | ';')+;

TYPE : 'int' | 'float';

ENTIER: ('0'..'9')+;
FLOAT : ('0'..'9')+ '.'('0'..'9')*;

ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';

WRITE: 'write';
READ : 'read';
WHILE: 'while';
IDENTIFIANT: [a-zA-Z]+[a-zA-Z0-9]*;

NEWLINE: '\r'? '\n';
WS: (' ' | '\t')+ -> skip;

COMMENT: '/*' .*? '*/' -> skip;

LINE_COMMENT: '//' ~[\r\n]* -> skip;
