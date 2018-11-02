package by.it.korzik.project.java.controller;

public enum Action {
    INDEX {{
        cmd= new CmdIndex();
    }},
    PROFILE {{
        cmd= new CmdProfile();
    }},
    ADMIN {{
        cmd= new CmdAdmin();
    }},
    ORDERSLIST {{
        cmd= new CmdOrdersList();
    }},
    CREATEORDER {{
        cmd= new CmdCreateOrder();
    }},
    LOGIN {{
        cmd= new CmdLogIn();
    }},
    CREATEMENU {{
        cmd= new CmdCreateMenu();
    }},
    RESET {{
        cmd= new CmdReset();
    }},
    SIGNUP {{
        cmd= new CmdSignUp();
    }},
    ERROR{{
        cmd= new CmdError();
    }};

    public String getJsp() {
        return "/" + this.cmd.toString().toLowerCase() + ".jsp";
    }
    public Cmd cmd= new CmdError();
}
