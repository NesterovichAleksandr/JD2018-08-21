package by.it.korolchuk.jd02_05.Calc_jd02_05;

interface Operation {
    Var add(Var other);

    Var sub(Var other);

    Var mul(Var other);

    Var div(Var other);
}