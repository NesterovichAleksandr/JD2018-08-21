package by.it.voinilo.project.java.controller;

import by.it.voinilo.project.java.beans.Ads;
import by.it.voinilo.project.java.beans.Roleparam;
import by.it.voinilo.project.java.entitydao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdCreateAd extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse response) throws Exception {
        HttpSession session = req.getSession(false);
        if (util.getUser(req) == null)
            return Action.LOGIN.cmd;


        if (Form.isPost(req)) {
            Roleparam user = util.getUser(req);

                String name = Form.getString(req, "name");
                String address = Form.getString(req, "address");
                String description = Form.getString(req, "description");
                String condition = Form.getString(req, "condition");
                String number = Form.getString(req, "number");
               int price = Form.getInt(req,"price");
            Ads ads = new Ads(0, description, address, name, price, condition,number, user.getId());
            Dao dao = Dao.getDao();
            dao.ad.create(ads);
            util.saveImage(req, "ads"+ ads.getId());

                return Action.PROFILE.cmd;
            }



        return null;
    }
}