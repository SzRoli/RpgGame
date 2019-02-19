package dao;


import javax.persistence.*;
import java.io.Serializable;

@Entity//emiat entity
@Table(name = "TABLEA", schema = "MY_OWN_SCHEMA")
@NamedQueries({
        //valamilyen feltételel lekérdezés, vagy csoportositás stb..
        @NamedQuery(name = "PlayerEntity.findPlayerMoney", query = "SELECT e.money FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerByName", query = "SELECT e FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerName", query = "SELECT e.name FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerDmg", query = "SELECT e.dmg FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerLvl", query = "SELECT e.lvl FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerCritical", query = "SELECT e.critical FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerCriticalDmg", query = "SELECT e.criticalDmg FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerResetCount", query = "SELECT e.resetCount FROM PlayerEntity e where e.name = :name")

})

public class PlayerEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false, updatable = false)
    private Long Id;

    @Column(name = "MONEY")
    private Integer money;

    @Column(name = "DMG")
    private Integer dmg;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "LVL")
    private Integer lvl;

    @Column (name = "CRITICAL")
    private Integer critical;

    @Column (name = "CRITICALDMG")
    private Integer criticalDmg;

    @Column (name = "RESETCOUNT")
    private Integer resetCount;




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

    public Integer getLvl(){ return this.lvl; }

    public void setLvl(Integer lvl) { this.lvl = lvl; }


    public Integer getDmg() {
        return dmg;
    }

    public void setDmg(Integer dmg) {
        this.dmg = dmg;
    }

    public Integer getCritical() {
        return this.critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    public Integer getCriticalDmg() {
        return this.criticalDmg;
    }

    public void setCriticalDmg(Integer criticalDmg) {
        this.criticalDmg = criticalDmg;
    }

    public Integer getResetCount() {
        return this.resetCount;
    }

    public void setResetCount(Integer resetCount) {
        this.resetCount = resetCount;
    }
}
