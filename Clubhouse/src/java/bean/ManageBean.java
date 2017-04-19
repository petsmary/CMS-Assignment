/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.BbqsFacadeRemote;
import ejb.BookingFacadeRemote;
import ejb.CustomersFacadeRemote;
import ejb.GymroomsFacadeRemote;
import ejb.SaunaroomsFacadeRemote;
import ejb.StudyroomsFacadeRemote;
import ejb.SwimmingpoolsFacadeRemote;
import entity.Bbqs;
import entity.Booking;
import entity.Gymrooms;
import entity.Saunarooms;
import entity.Studyrooms;
import entity.Swimmingpools;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import util.SessionUtils;

/**
 *
 * @author MingWai
 */
@Named(value = "manage")
@SessionScoped
public class ManageBean implements Serializable {

    @EJB
    private SwimmingpoolsFacadeRemote swimmingpoolsFacade;

    @EJB
    private StudyroomsFacadeRemote studyroomsFacade;

    @EJB
    private SaunaroomsFacadeRemote saunaroomsFacade;

    @EJB
    private GymroomsFacadeRemote gymroomsFacade;

    @EJB
    private BookingFacadeRemote bookingFacade;

    @EJB
    private BbqsFacadeRemote bbqsFacade;

    @EJB
    private CustomersFacadeRemote customersFacade;

    private static final String[] FACILITES = {"BBQs", "Gym Rooms", "Swimming Pools", "Sauna Rooms", "Study Rooms"};
    private Map<String, String> availableItems;
    private Map<String, String> dateList;
    private String facility = FACILITES[0];
    private String id;
    private boolean successful;
    private boolean full;
    private boolean check;    

    private String type;
    private String nameadd;
    private String location;
    private Integer limit;
    private Date date;
    private String open;
    private String end;
    DateFormat sdf = new SimpleDateFormat("hh:mm:ss");

    public ManageBean() {
        availableItems = new LinkedHashMap<String, String>();
        availableItems.put(FACILITES[0], FACILITES[0]);
        availableItems.put(FACILITES[1], FACILITES[1]);
        availableItems.put(FACILITES[2], FACILITES[2]);
        availableItems.put(FACILITES[3], FACILITES[3]);
        availableItems.put(FACILITES[4], FACILITES[4]);        
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameadd() {
        return nameadd;
    }

    public void setNameadd(String nameadd) {
        this.nameadd = nameadd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Map<String, String> getAvailableItems() {
        return availableItems;
    }

    public void add() {
        try {
            if (type.equals(FACILITES[0])) {
                int i = bbqsFacade.findAll().size();
                String bbqId = "Q0001";
                if (i < 9) {
                    bbqId = "Q000" + (i + 1);
                } else if (i >= 9 && i < 99) {
                    bbqId = "Q00" + (i + 1);
                }
                if (i >= 99 && i < 999) {
                    bbqId = "Q0" + (i + 1);
                }
                if (i >= 999 && i < 9999) {
                    bbqId = "Q" + (i + 1);
                }
                Bbqs bbq = new Bbqs(bbqId, nameadd, location, sdf.parse(open), sdf.parse(end), limit, date, 0);
                bbqsFacade.create(bbq);
            } else if (facility.equals(FACILITES[1])) {
                int i = gymroomsFacade.findAll().size();
                String bbqId = "G0001";
                if (i < 9) {
                    bbqId = "G000" + (i + 1);
                } else if (i >= 9 && i < 99) {
                    bbqId = "G00" + (i + 1);
                }
                if (i >= 99 && i < 999) {
                    bbqId = "G0" + (i + 1);
                }
                if (i >= 999 && i < 9999) {
                    bbqId = "G" + (i + 1);
                }
                Gymrooms bbq = new Gymrooms(bbqId, nameadd, location, sdf.parse(open), sdf.parse(end), limit, date, 0);
                gymroomsFacade.create(bbq);
            } else if (facility.equals(FACILITES[2])) {
                int i = swimmingpoolsFacade.findAll().size();
                String bbqId = "P0001";
                if (i < 9) {
                    bbqId = "P000" + (i + 1);
                } else if (i >= 9 && i < 99) {
                    bbqId = "P00" + (i + 1);
                }
                if (i >= 99 && i < 999) {
                    bbqId = "P0" + (i + 1);
                }
                if (i >= 999 && i < 9999) {
                    bbqId = "P" + (i + 1);
                }
                Swimmingpools bbq = new Swimmingpools(bbqId, nameadd, location, sdf.parse(open), sdf.parse(end), limit, date, 0);
                swimmingpoolsFacade.create(bbq);
            } else if (facility.equals(FACILITES[3])) {
                int i = saunaroomsFacade.findAll().size();
                String bbqId = "A0001";
                if (i < 9) {
                    bbqId = "A000" + (i + 1);
                } else if (i >= 9 && i < 99) {
                    bbqId = "A00" + (i + 1);
                }
                if (i >= 99 && i < 999) {
                    bbqId = "A0" + (i + 1);
                }
                if (i >= 999 && i < 9999) {
                    bbqId = "A" + (i + 1);
                }
                Saunarooms bbq = new Saunarooms(bbqId, nameadd, location, sdf.parse(open), sdf.parse(end), limit, date, 0);
                saunaroomsFacade.create(bbq);
            } else if (facility.equals(FACILITES[4])) {
                int i = studyroomsFacade.findAll().size();
                String bbqId = "T0001";
                if (i < 9) {
                    bbqId = "T000" + (i + 1);
                } else if (i >= 9 && i < 99) {
                    bbqId = "T00" + (i + 1);
                }
                if (i >= 99 && i < 999) {
                    bbqId = "T0" + (i + 1);
                }
                if (i >= 999 && i < 9999) {
                    bbqId = "T" + (i + 1);
                }
                Studyrooms bbq = new Studyrooms(bbqId, nameadd, location, sdf.parse(open), sdf.parse(end), limit, date, 0);
                studyroomsFacade.create(bbq);
            }
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Add FACILITES Complete"));
        } catch (Exception ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error with your start time or end time"));
        }
    }

    public Map<String, String> getDateList() {
        dateList = new LinkedHashMap<String, String>();
        if (facility.equals(FACILITES[0])) {
            List<Bbqs> list = getShowBbqs();
            for (int i = 0; i < list.size(); i++) {
                dateList.put(list.get(i).getBbqId() + "", (list.get(i).getDate() + ", " + list.get(i).getOpen().getHours() + ":00 to " + list.get(i).getEnd().getHours() + ":00"));
            }
        } else if (facility.equals(FACILITES[1])) {
            List<Gymrooms> list = getShowGymrooms();
            for (int i = 0; i < list.size(); i++) {
                dateList.put(list.get(i).getGymId() + "", (list.get(i).getDate() + ", " + list.get(i).getOpen().getHours() + ":00 to " + list.get(i).getEnd().getHours() + ":00"));
            }
        } else if (facility.equals(FACILITES[2])) {
            List<Swimmingpools> list = getShowSwimmingpools();
            for (int i = 0; i < list.size(); i++) {
                dateList.put(list.get(i).getPoolId() + "", (list.get(i).getDate() + ", " + list.get(i).getOpen().getHours() + ":00 to " + list.get(i).getEnd().getHours() + ":00"));
            }
        } else if (facility.equals(FACILITES[3])) {
            List<Saunarooms> list = getShowSaunarooms();
            for (int i = 0; i < list.size(); i++) {
                dateList.put(list.get(i).getSaunaId() + "", (list.get(i).getDate() + ", " + list.get(i).getOpen().getHours() + ":00 to " + list.get(i).getEnd().getHours() + ":00"));
            }
        } else if (facility.equals(FACILITES[4])) {
            List<Studyrooms> list = getShowStudyrooms();
            for (int i = 0; i < list.size(); i++) {
                dateList.put(list.get(i).getStudyId() + "", (list.get(i).getDate() + ", " + list.get(i).getOpen().getHours() + ":00 to " + list.get(i).getEnd().getHours() + ":00"));
            }
        }
        return dateList;
    }

    public void book() {
        if (facility.equals(FACILITES[0])) {
            Bbqs bbq = bbqsFacade.find(id);
            boolean check = bookingFacade.check(SessionUtils.getUserId(), id, 0);
            if (bbq.getLimited() > bbq.getTaken() && check) {
                int i = bookingFacade.findAll().size();
                Booking booking = new Booking();
                if (i < 9) {
                    booking = new Booking("B000" + (i + 1), "booked");
                } else if (i >= 9 && i < 99) {
                    booking = new Booking("B00" + (i + 1), "booked");
                }
                if (i >= 99 && i < 999) {
                    booking = new Booking("B0" + (i + 1), "booked");
                }
                if (i >= 999 && i < 9999) {
                    booking = new Booking("B" + (i + 1), "booked");
                }
                booking.setSchBbqId(bbq);
                booking.setSchCustId(customersFacade.find(SessionUtils.getUserId()));
                bookingFacade.create(booking);
                bbq.setTaken(bbq.getTaken() + 1);
                bbqsFacade.edit(bbq);
                this.successful = true;
                this.full = false;
                this.check = false;
            } else if (!check) {
                this.successful = false;
                this.full = false;
                this.check = true;
            } else {
                this.successful = false;
                this.full = true;
                this.check = false;
            }

        } else if (facility.equals(FACILITES[1])) {
            Gymrooms bbq = gymroomsFacade.find(id);
            boolean check = bookingFacade.check(SessionUtils.getUserId(), id, 1);
            if (bbq.getLimited() > bbq.getTaken() && check) {
                bbq.setTaken(bbq.getTaken() + 1);
                gymroomsFacade.edit(bbq);
                int i = bookingFacade.findAll().size();
                Booking booking = new Booking();
                if (i < 9) {
                    booking = new Booking("B000" + (i + 1), "booked");
                } else if (i >= 9 && i < 99) {
                    booking = new Booking("B00" + (i + 1), "booked");
                }
                if (i >= 99 && i < 999) {
                    booking = new Booking("B0" + (i + 1), "booked");
                }
                if (i >= 999 && i < 9999) {
                    booking = new Booking("B" + (i + 1), "booked");
                }
                booking.setSchGymId(bbq);
                booking.setSchCustId(customersFacade.find(SessionUtils.getUserId()));
                bookingFacade.create(booking);
                this.successful = true;
                this.full = false;
                this.check = false;
            } else if (!check) {
                this.successful = false;
                this.full = false;
                this.check = true;
            } else {
                this.successful = false;
                this.full = true;
                this.check = false;
            }
        } else if (facility.equals(FACILITES[2])) {
            Swimmingpools bbq = swimmingpoolsFacade.find(id);
            boolean check = bookingFacade.check(SessionUtils.getUserId(), id, 2);
            if (bbq.getLimited() > bbq.getTaken() && check) {
                bbq.setTaken(bbq.getTaken() + 1);
                swimmingpoolsFacade.edit(bbq);
                int i = bookingFacade.findAll().size();
                Booking booking = new Booking();
                if (i < 9) {
                    booking = new Booking("B000" + (i + 1), "booked");
                } else if (i >= 9 && i < 99) {
                    booking = new Booking("B00" + (i + 1), "booked");
                }
                if (i >= 99 && i < 999) {
                    booking = new Booking("B0" + (i + 1), "booked");
                }
                if (i >= 999 && i < 9999) {
                    booking = new Booking("B" + (i + 1), "booked");
                }
                booking.setSchPoolId(bbq);
                booking.setSchCustId(customersFacade.find(SessionUtils.getUserId()));
                bookingFacade.create(booking);
                this.successful = true;
                this.full = false;
                this.check = false;
            } else if (!check) {
                this.successful = false;
                this.full = false;
                this.check = true;
            } else {
                this.successful = false;
                this.full = true;
                this.check = false;
            }
        } else if (facility.equals(FACILITES[3])) {
            Saunarooms bbq = saunaroomsFacade.find(id);
            boolean check = bookingFacade.check(SessionUtils.getUserId(), id, 3);
            if (bbq.getLimited() > bbq.getTaken() && check) {
                bbq.setTaken(bbq.getTaken() + 1);
                saunaroomsFacade.edit(bbq);
                int i = bookingFacade.findAll().size();
                Booking booking = new Booking();
                if (i < 9) {
                    booking = new Booking("B000" + (i + 1), "booked");
                } else if (i >= 9 && i < 99) {
                    booking = new Booking("B00" + (i + 1), "booked");
                }
                if (i >= 99 && i < 999) {
                    booking = new Booking("B0" + (i + 1), "booked");
                }
                if (i >= 999 && i < 9999) {
                    booking = new Booking("B" + (i + 1), "booked");
                }
                booking.setSchSaunaId(bbq);
                booking.setSchCustId(customersFacade.find(SessionUtils.getUserId()));
                bookingFacade.create(booking);
                this.successful = true;
                this.full = false;
                this.check = false;
            } else if (!check) {
                this.successful = false;
                this.full = false;
                this.check = true;
            } else {
                this.successful = false;
                this.full = true;
                this.check = false;
            }
        } else if (facility.equals(FACILITES[4])) {
            Studyrooms bbq = studyroomsFacade.find(id);
            boolean check = bookingFacade.check(SessionUtils.getUserId(), id, 4);
            if (bbq.getLimited() > bbq.getTaken() && check) {
                bbq.setTaken(bbq.getTaken() + 1);
                studyroomsFacade.edit(bbq);
                int i = bookingFacade.findAll().size();
                Booking booking = new Booking();
                if (i < 9) {
                    booking = new Booking("B000" + (i + 1), "booked");
                } else if (i >= 9 && i < 99) {
                    booking = new Booking("B00" + (i + 1), "booked");
                }
                if (i >= 99 && i < 999) {
                    booking = new Booking("B0" + (i + 1), "booked");
                }
                if (i >= 999 && i < 9999) {
                    booking = new Booking("B" + (i + 1), "booked");
                }
                booking.setSchStudyId(bbq);
                booking.setSchCustId(customersFacade.find(SessionUtils.getUserId()));
                bookingFacade.create(booking);
                this.successful = true;
                this.full = false;
                this.check = false;
            } else if (!check) {
                this.successful = false;
                this.full = false;
                this.check = true;
            } else {
                this.successful = false;
                this.full = true;
                this.check = false;
            }
        }
    }

    public void setFalse() {
        this.successful = false;
        this.full = false;
        this.check = false;
    }

    public List<Bbqs> getShowBbqs() {
        return bbqsFacade.findAll();
    }

    public List<Gymrooms> getShowGymrooms() {
        return gymroomsFacade.findAll();
    }

    public List<Saunarooms> getShowSaunarooms() {
        return saunaroomsFacade.findAll();
    }

    public List<Studyrooms> getShowStudyrooms() {
        return studyroomsFacade.findAll();
    }

    public List<Swimmingpools> getShowSwimmingpools() {
        return swimmingpoolsFacade.findAll();
    }
}
