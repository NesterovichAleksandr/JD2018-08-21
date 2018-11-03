package by.it.voinilo.project.java.controller;

public enum Action {
    SEARCH{{cmd= new CmdSearch();}},GOTOADMINPAGE {{cmd = new CmdGotoAdminPage();}},
    PROFILE{{
        cmd=new CmdProfile();
    }},
    INDEX {{

        cmd =new CmdIndex();
    }},
    LOGIN {{

        cmd =new CmdLogin();
    }},
    SIGNUP {{

        cmd =new CmdSignUp();
    }}
    ,
    CREATEAD {{

        cmd =new CmdCreateAd();
    }},
    ERROR {{

        cmd =new CmdError();
    }},
    RESET {{cmd= new CmdReset();}};

    public String getJsp(){ return "/"+this.cmd.toString().toLowerCase() +".jsp";}
    public  Cmd cmd =new CmdError();

}
