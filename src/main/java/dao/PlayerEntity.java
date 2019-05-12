package dao;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity of a player.
 */
@Entity
@Table(name = "TABLEB", schema = "MY_OWN_SCHEMA")
@NamedQueries({

        @NamedQuery(name = "PlayerEntity.findPlayerMoney", query = "SELECT e.money FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerByName", query = "SELECT e FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerName", query = "SELECT e.name FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerDmg", query = "SELECT e.dmg FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerLvl", query = "SELECT e.lvl FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerCritical", query = "SELECT e.critical FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerCriticalDmg", query = "SELECT e.criticalDmg FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerResetCount", query = "SELECT e.resetCount FROM PlayerEntity e where e.name = :name"),
        @NamedQuery(name = "PlayerEntity.findPlayerAiDmg", query = "SELECT e.aiDmg FROM PlayerEntity e where e.name = :name")

})

/**
 * PlayerEntity represents an entity for JPA.
 */
public class PlayerEntity implements Serializable {
    /**
     * Automatic generated first key for entity. Obligatory.
     */
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false, updatable = false)
    private Long Id;

    /**
     * Representing Player's money in the database.
     */
    @Column(name = "MONEY")
    private Integer money;
    /**
     * Representing Player's aidmg in the database.
     */
    @Column(name = "AIDMG")
    private Integer aiDmg;
    /**
     * Representing Player's dmg in the database.
     */
    @Column(name = "DMG")
    private Integer dmg;
    /**
     * Representing Player's name in the database.
     */
    @Column(name = "NAME", unique = true, nullable = false)
    private String name;
    /**
     * Representing Player's lvl in the database.
     */
    @Column(name = "LVL")
    private Integer lvl;
    /**
     * Representing Player's critical chance in the database.
     */
    @Column (name = "CRITICAL")
    private Integer critical;
    /**
     * Representing Player's critical damage in the database.
     */
    @Column (name = "CRITICALDMG")
    private Integer criticalDmg;
    /**
     * Representing Player's reset count in the database.
     */
    @Column (name = "RESETCOUNT")
    private Integer resetCount;

    /**
     * Getter for get back AiDmg.
     * @return a number of AiDmg
     */
    public Integer getAiDmg() {
        return aiDmg;
    }
    /**
     * Setter for aiDmg variable.
     *
     * @param aiDmg amount of aiDmg we want to set.
     */
    public void setAiDmg(Integer aiDmg) {
        this.aiDmg = aiDmg;
    }
    /**
     * Getter for Id variable.
     *
     * @return Id of the PlayerEntity
     */
    public Long getId() {
        return Id;
    }
    /**
     * Setter for money variable.
     *
     * @param amount amount of money we want to set.
     */
    public void setMoney(Integer amount) {
        this.money = amount;
    }

    /**
     * Getter for money variable.
     *
     * @return money of the PlayerEntity
     */
    public Integer getMoney(){
        return this.money;
    }
    /**
     * Getter for name.
     *
     * @return name of the PlayerEntity
     */
    public String getName(){ return this.name; }

    /**
     * Setter for name.
     * @param name we want to set.
     */
    public void setName(String name) { this.name = name; }

    /**
     * Getter for LvL.
     * @return lvl of the PlayerEntity
     */
    public Integer getLvl(){ return this.lvl; }

    /**
     * Setter for LvL.
     * @param lvl we want to set
     */
    public void setLvl(Integer lvl) { this.lvl = lvl; }

    /**
     * Getter for Damage.
     * @return dmg of the PlayerEntity
     */
    public Integer getDmg() {
        return dmg;
    }

    /**
     * Setter for Damage.
     * @param dmg we want to set
     */
    public void setDmg(Integer dmg) {
        this.dmg = dmg;
    }

    /**
     * Getter for Critical Chance.
     * @return critical chance of the PlayerEntity
     */
    public Integer getCritical() {
        return this.critical;
    }

    /**
     * Setter for Critical Chance.
     * @param critical we want to set
     */
    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    /**
     * Getter for Critical Damage.
     * @return Critical Damage of the PlayerEntity
     */
    public Integer getCriticalDmg() {
        return this.criticalDmg;
    }

    /**
     * Setter for Critical Damage.
     * @param criticalDmg we want to set
     */
    public void setCriticalDmg(Integer criticalDmg) {
        this.criticalDmg = criticalDmg;
    }

    /**
     * Getter for Reset Count.
     * @return Reset Count of the PlayerEntity
     */
    public Integer getResetCount() {
        return this.resetCount;
    }

    /**
     * Setter of the reset count.
     * @param resetCount we want to set.
     */
    public void setResetCount(Integer resetCount) {
        this.resetCount = resetCount;
    }
}
