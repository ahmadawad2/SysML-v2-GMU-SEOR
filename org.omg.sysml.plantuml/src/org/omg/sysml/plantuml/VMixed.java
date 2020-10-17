/*****************************************************************************
 * SysML 2 Pilot Implementation, PlantUML Visualization
 * Copyright (c) 2020 Mgnite Inc.
 *    
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of theGNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * @license LGPL-3.0-or-later <http://spdx.org/licenses/LGPL-3.0-or-later>
 * 
 * Contributors:
 *  Hisashi Miyashita, Mgnite Inc.
 * 
 *****************************************************************************/

package org.omg.sysml.plantuml;

import org.omg.sysml.lang.sysml.ActionDefinition;
import org.omg.sysml.lang.sysml.ActionUsage;
import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.lang.sysml.StateDefinition;
import org.omg.sysml.lang.sysml.StateUsage;

public class VMixed extends VTree {
    private static final SysML2PlantUMLStyle style
    = new SysML2PlantUMLStyle("VMixed", null, "", null);

    @Override 
    protected SysML2PlantUMLStyle getStyle() {
        return style;
    }

    @Override
    protected VTree newVTree(Element parent) {
        return new VMixed(this, parent);
    }

    /***************************************************
     * Delegation Methods for VAction
     ***************************************************/

    @Override
    public String caseActionDefinition(ActionDefinition ad) {
        VAction va = new VAction(this);
        va.caseActionDefinition(ad);
        va.flush();
        return "";
    }

    @Override
    public String caseActionUsage(ActionUsage au) {
        VAction va = new VAction(this);
        va.caseActionUsage(au);
        va.flush();
        return "";
    }

    /***************************************************
     * Delegation Methods for VStateMachine
     ***************************************************/

    @Override
    public String caseStateUsage(StateUsage su) {
        VStateMachine vs = new VStateMachine(this);
        vs.caseStateUsage(su);
        vs.flush();
        return "";
    }
    
    @Override
    public String caseStateDefinition(StateDefinition sd) {
        VStateMachine vs = new VStateMachine(this);
        vs.caseStateDefinition(sd);
        vs.flush();
        return "";
    }

    private VMixed(VTree vt, Element parent) {
        super(vt, parent);
    }

    public VMixed() {
        super();
    }
}