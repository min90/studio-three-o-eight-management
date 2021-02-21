package studie.three.o.eight.management.service.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateTimeDeserializer;
import org.joda.time.LocalDateTime;
import studie.three.o.eight.management.domain.Caretaker;
import studie.three.o.eight.management.domain.Planning;
import studie.three.o.eight.management.domain.Revenue;
import studie.three.o.eight.management.domain.Staff;

import java.util.ArrayList;

public class ClientRequest {

    private String id;
    private String name;
    private int interval;
    private boolean open;
    private boolean withoutTimeslot;
    private String password;
    private String info;
    private boolean natureSession;
    private boolean siblingSession;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime availableFrom;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime availableTo;
    private int childrenCount;
    private int staffCount;
    private int groupCount;
    private String groups;
    private String organizationForm;
    private String planning;
    private String note;
    private boolean rebooked;
    private String roadName;
    private int zipCode;
    private String city;
    private ArrayList<Revenue> revenues;
    private ArrayList<Planning> plannings;
    private ArrayList<Staff> staffs;
    private ArrayList<Caretaker> caretakers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isWithoutTimeslot() {
        return withoutTimeslot;
    }

    public void setWithoutTimeslot(boolean withoutTimeslot) {
        this.withoutTimeslot = withoutTimeslot;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isNatureSession() {
        return natureSession;
    }

    public void setNatureSession(boolean natureSession) {
        this.natureSession = natureSession;
    }

    public boolean isSiblingSession() {
        return siblingSession;
    }

    public void setSiblingSession(boolean siblingSession) {
        this.siblingSession = siblingSession;
    }

    public LocalDateTime getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(LocalDateTime availableFrom) {
        this.availableFrom = availableFrom;
    }

    public LocalDateTime getAvailableTo() {
        return availableTo;
    }

    public void setAvailableTo(LocalDateTime availableTo) {
        this.availableTo = availableTo;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }

    public int getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(int staffCount) {
        this.staffCount = staffCount;
    }

    public int getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(int groupCount) {
        this.groupCount = groupCount;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getOrganizationForm() {
        return organizationForm;
    }

    public void setOrganizationForm(String organizationForm) {
        this.organizationForm = organizationForm;
    }

    public String getPlanning() {
        return planning;
    }

    public void setPlanning(String planning) {
        this.planning = planning;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isRebooked() {
        return rebooked;
    }

    public void setRebooked(boolean rebooked) {
        this.rebooked = rebooked;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<Revenue> getRevenues() {
        return revenues;
    }

    public void setRevenues(ArrayList<Revenue> revenues) {
        this.revenues = revenues;
    }

    public ArrayList<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(ArrayList<Planning> plannings) {
        this.plannings = plannings;
    }

    public ArrayList<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(ArrayList<Staff> staffs) {
        this.staffs = staffs;
    }

    public ArrayList<Caretaker> getCaretakers() {
        return caretakers;
    }

    public void setCaretakers(ArrayList<Caretaker> caretakers) {
        this.caretakers = caretakers;
    }

    @Override
    public String toString() {
        return "ClientRequest{" +
                "name='" + name + '\'' +
                ", interval=" + interval +
                ", open=" + open +
                ", withoutTimeslot=" + withoutTimeslot +
                ", password='" + password + '\'' +
                ", info='" + info + '\'' +
                ", natureSession=" + natureSession +
                ", siblingSession=" + siblingSession +
                ", availableFrom=" + availableFrom +
                ", availableTo=" + availableTo +
                ", revenues=" + revenues +
                '}';
    }
}
