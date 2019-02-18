package dao;


import javax.persistence.*;
import java.io.Serializable;

@Entity//emiat entity
@Table(name = "PLAYER", schema = "MY_OWN_SCHEMA")
@NamedQueries({
        //valamilyen feltételel lekérdezés, vagy csoportositás stb..
        @NamedQuery(name = "PlayerEntity.findPlayerMoney", query = "SELECT e.money FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerByName", query = "SELECT e FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerName", query = "SELECT e.name FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerHp", query = "SELECT e.hp FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerDmg", query = "SELECT e.dmg FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerDef", query = "SELECT e.def FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerDoge", query = "SELECT e.doge FROM PlayerEntity e where e.name = :name"),
        //@NamedQuery(name = "PlayerEntity.findPlayerbyClass", query = "SELECT e.classes FROM PlayerEntity e where e.myname = :name"),
        //@NamedQuery(name = "PlayerEntity.findPlayerbySpeacies", query = "SELECT e.speacies FROM PlayerEntity e where e.myname = :name"),
        //@NamedQuery(name = "PlayerEntity.findPlayerbyGender", query = "SELECT e.gender FROM PlayerEntity e where e.myname = :name"),
        //@NamedQuery(name = "PlayerEntity.findPlayer", query = "SELECT e FROM PlayerEntity AS e")
})

public class PlayerEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false, updatable = false)
    private Long Id;

    @Column(name = "MONEY")
    private Integer money;

    @Column(name = "HP")
    private Integer hp;

    @Column(name = "DMG")
    private Integer dmg;

    @Column(name = "DEF")
    private Integer def;

    @Column(name = "DOGE")
    private Integer doge;

    @Column(name = "CLASS")
    private String classes;

    @Column(name = "SPEACIES")
    private String speacies;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;


    public Long getId() {
        return Id;
    }

    public void setMoney(Integer amount) {
        this.money = amount;
    }


    public Integer getMoney(){
        return this.money;
    }

    public String getName(){ return this.name; }

    public void setName(String name) { this.name = name; }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getDmg() {
        return dmg;
    }

    public void setDmg(Integer dmg) {
        this.dmg = dmg;
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public Integer getDoge() {
        return doge;
    }

    public void setDoge(Integer doge) {
        this.doge = doge;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getSpeacies() {
        return speacies;
    }

    public void setSpeacies(String speacies) {
        this.speacies = speacies;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
