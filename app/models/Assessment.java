package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Assessment extends Model
{
    public float weight;
    public float chest;
    public float thigh;
    public float upperarm;
    public float waist;
    public float hips;


    public Assessment(float weight, float chest, float thigh, float upperarm, float waist, float hips)
    {
        this.weight = weight;
        this.chest = chest;
        this.thigh = thigh;
        this.upperarm = upperarm;
        this.waist = waist;
        this.hips = hips;
    }
}

