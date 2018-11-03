package by.it.kisielev.jd02_04.v2;

public class Patterns {
    static final String OPERATION="(?<=[^-+*/=,{])[-+=/*]";
    static final String SCALAR="-?\\d+(.\\d+)?";
    static final String VECTOR="\\{((-?\\d+(.\\d+)?),?)+}";
    static final String MATRIX="\\{((\\{((-?\\d+(.\\d+)?),?)+}),?)+}";

}
