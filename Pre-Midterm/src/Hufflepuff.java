/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TEXR
 */
public class Hufflepuff extends Houses implements Magicable{
    public Hufflepuff() {
        super("Hufflepuff", "YELLOW");
    }

    @Override
    public void attckSpell(Player player, Player target, Spell spell) {
        if (spell instanceof Incendio) {
            int totalDamage = spell.getDamage() + player.getAttackDamage();
            target.setHP(target.getHP() - totalDamage);
            player.setMana(player.getMana() - 3);
        } else if (spell instanceof Expelliarmus) {
            int totalDamage = spell.getDamage() + player.getAttackDamage();
            target.setHP(target.getHP() - totalDamage);
            player.setMana(player.getMana() - 4);
        }
        System.out.println("["+player.getName()+"]: use spell ("+spell.getName()+")!");
    }

    @Override
    public void defence(Player player, Player damager) {
        player.setHP(player.getHP() + 4);
        player.setMana(player.getMana() + 3);
        System.out.println("["+player.getName()+"]: Protego !");
    }
}
