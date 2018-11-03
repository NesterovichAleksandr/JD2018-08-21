package by.it.yaroshchuk.project.java.controller;

public enum Action {

    INDEX {{
            cmd = new CmdIndex();
        }},
    RESET {{
            cmd = new CmdReset();
        }},
    LOGIN {{
            cmd = new CmdLogin();
        }},
    LOGOUT {{
            cmd = new CmdLogout();
        }},
    SIGNUP {{
            cmd = new CmdSignUp();
        }},
    CREATERESUME {{
            cmd = new CmdCreateResume();
        }},
    COMPANYLISTRESUMES {{
            cmd = new CmdCompanyListResumes();
    }},
    USERLISTRESUMES {{
            cmd = new CmdUserListResumes();
    }},
    USERSREQUESTS {{
        cmd = new CmdUsersRequests();
    }},
    USERPROFILE {{
        cmd = new CmdUserProfile();
    }},
    EDITUSERS {{
        cmd = new CmdEditUsers();
    }},
    EDITRESUMES {{
        cmd = new CmdEditResumes();
    }},
    EDITCOMPANIES {{
        cmd = new CmdEditCompanies();
    }},
    REQUESTS {{
        cmd = new CmdRequests();
    }},
    ERROR {{
            cmd = new CmdError();
        }};

    public String getJsp() {
        return "/" + this.cmd.toString().toLowerCase() + ".jsp";
    }

    public Cmd cmd = new CmdError();
}
