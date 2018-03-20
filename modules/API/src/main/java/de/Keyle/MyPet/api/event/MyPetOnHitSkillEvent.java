/*
 * This file is part of MyPet
 *
 * Copyright © 2011-2018 Keyle
 * MyPet is licensed under the GNU Lesser General Public License.
 *
 * MyPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MyPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package de.Keyle.MyPet.api.event;

import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.player.MyPetPlayer;
import de.Keyle.MyPet.api.skill.OnHitSkill;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MyPetOnHitSkillEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    protected boolean isCancelled = false;

    protected final MyPet myPet;
    protected final OnHitSkill skill;
    protected LivingEntity target;

    public MyPetOnHitSkillEvent(MyPet myPet, OnHitSkill skill, LivingEntity target) {
        this.myPet = myPet;
        this.skill = skill;
        this.target = target;
    }

    public MyPet getMyPet() {
        return myPet;
    }

    public OnHitSkill getSkill() {
        return skill;
    }

    public MyPetPlayer getOwner() {
        return myPet.getOwner();
    }

    public LivingEntity getTarget() {
        return target;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    @SuppressWarnings("unused")
    public static HandlerList getHandlerList() {
        return handlers;
    }
}