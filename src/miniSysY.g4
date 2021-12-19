grammar miniSysY;

//语法
compUnit : decl* funcDef;
funcDef  : funcType Ident L_PAREN R_PAREN block;
funcType : INT;
block    : L_BRACE blockItem* R_BRACE;
blockItem : stmt | decl;
stmt     : retStatement|assignStatement|expStatement|condStatement;
retStatement:RETURN exp SEMICOLON;
assignStatement:lVal ASSIGN exp SEMICOLON;
decl         : constDecl | varDecl;
constDecl    : CONST bType constDef (COMMA constDef)*';';
bType        : INT;
constDef     : Ident ASSIGN constInitVal;
constInitVal : constExp;
constExp     : addExp;
lVal         : Ident;
varDecl      : bType varDef (COMMA varDef)* ';';
varDef       : Ident
                | Ident '=' initVal;
initVal      : exp;
expStatement:exp? SEMICOLON;
exp        : addExp;
addExp     : addExp (ADD
                       | SUB) mulExp| mulExp  ;
mulExp     : mulExp (MUL
                        | DIV
                        | MOD) unaryExp| unaryExp;
unaryExp   : primaryExp #priE
            | sign=(ADD|SUB|NOT) unaryExp #unaryOpExp
            | Ident L_PAREN funcRParams? R_PAREN #libfunc
            ;
funcRParams  : exp (COMMA exp)*;
primaryExp : L_PAREN exp R_PAREN #braces
            |Number #num
            |lVal   #left
             ;
condStatement:IF L_PAREN cond R_PAREN stmt ( ELSE stmt )?;
cond         : lOrExp ;
relExp       : addExp
                | relExp sign=(GR | LR | GE | LE) addExp ;// [new]
eqExp        : relExp
                | eqExp sign=(EQUAL | NOTEQUAL) relExp ; // [new]
lAndExp      : eqExp
                | lAndExp AND eqExp ; // [new]
lOrExp       : lAndExp
                | lOrExp OR lAndExp ; // [new]



//词法
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
MOD: '%';
ASSIGN:'=';
L_PAREN: '(';
R_PAREN: ')';
L_BRACE: '{';
R_BRACE: '}';
INT: 'int';
CONST:'const';
COMMA:',';
//MAIN: 'main';
RETURN: 'return';
SEMICOLON: ';';
IF:'if';
ELSE:'else';
NOT:'!';
GR:'>';
LR:'<';
GE:'>=';
LE:'<=';
EQUAL:'==';
NOTEQUAL:'!=';
AND:'&&';
OR:'||';

//用正则匹配简化词法规则
Ident   : [a-zA-Z_] [a-zA-Z0-9_]*;
Number             : Decimal_const | Octal_const | Hexadecimal_const;
Hexadecimal_const: ('0x' | '0X') [a-fA-F0-9]+;
Octal_const: '0' [0-7]*;
Decimal_const: [1-9] [0-9]*;
WS  :  [ \t\r\n]+ -> skip;
LINES_COMMENT :   '/*' .*? '*/' -> channel(HIDDEN);
SIGNLE_LINE_COMMENT:   '//' ~[\r\n]* -> channel(HIDDEN);
