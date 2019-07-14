package model;

import base.Damage;
import base.Role;

import java.util.Random;

/**
 * @author 675056544@qq.com 2019-07-13 16:15:00
 */
public class Theresa extends Role {
    public static final String NAME = "德丽莎";
    private static final Long ATK = 24L;
    private static final Long DEF = 8L;
    private static final Long MAX_HP = 100L;
    private static final int SKILL_ROUND = 2;
    private static final int SKILL_TIMES = 4;

    private Random rand = new Random();

    public Theresa (){
        super(NAME, ATK, DEF, MAX_HP, 0, 0.0, SKILL_ROUND);
    }

    @Override
    public void skillAttack(Role target) {
        Long damageCount = 0L;
        for (int i = 0; i < SKILL_TIMES; i++) {
            //造成无视防御的伤害，目标防御力不参与计算
            long magicDamage = rand.nextInt(16) + 1L;
            Damage damage = new Damage(0L, magicDamage);
            target.underAttack(damage);
            damageCount += magicDamage;
        }

        System.out.println(this.getName() + "发动必杀技，对" + target.getName() + "累计造成" + damageCount + "点伤害");
    }
}