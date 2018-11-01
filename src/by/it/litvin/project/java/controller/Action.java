package by.it.litvin.project.java.controller;

enum Action {

   INDEX {{
       cmd = new CmdIndex();
   }},
   LOGIN {{
       cmd = new CmdLogin();
   }},
   RESET {{
       cmd = new CmdReset();
   }},
    EDITUSERS {{
        cmd = new CmdEditUsers();
    }},
   PROFILE {{
       cmd = new CmdProfile();
   }},
   CREATEFORM {{
       cmd = new CmdCreateForm();
   }},
   SIGNUP {{
       cmd = new CmdSignup();
   }},
   ERROR {{
       cmd = new CmdError();
   }};

   public String getJsp() {
       return "/" + this.cmd.toString().toLowerCase() + ".jsp";
   }

   public Cmd cmd = new CmdError();
}
