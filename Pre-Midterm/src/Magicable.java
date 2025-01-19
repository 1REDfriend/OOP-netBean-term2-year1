/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TEXR
 */
public interface Magicable {
   public abstract void attckSpell(Player player, Player target, Spell spell);
   
   public void defence(Player player, Player damager);
}
