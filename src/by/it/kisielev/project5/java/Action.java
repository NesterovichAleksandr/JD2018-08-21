package by.it.kisielev.project5.java;

enum Action {
    INDEX{{
        cmd = new CmdIndex();
    }},
    RESET{{
        cmd = new CmdReset();
    }},
    LOGIN{{
        cmd = new CmdLogin();
    }},
    CREATEAD{{
        cmd = new CmdCreateAd();
    }},
    SIGNUP{{
        cmd = new CmdSingup();
    }},
    ERROR{{
        cmd=new CmdError();
    }};
    public String getJSP(){return "/"+this.cmd.toString().toLowerCase()+".jsp"; };
    public Cmd cmd = new CmdError();
}
