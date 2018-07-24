package com.gatheringhallstudios.mhworlddatabase.data.models

import android.arch.persistence.room.Embedded


open class SkillTreeBase(
        val id: Int,
        val name: String?,
        val icon_color: String?
)

/**
 * Basic representation of a skill tree.
 * This is returned when querying for all data.
 * Created by Carlos on 3/6/2018.
 */
open class SkillTree(
        id: Int,
        name: String?,
        icon_color: String?,
        val description: String?
): SkillTreeBase(id, name, icon_color)

/**
 * A skill tree with skill information included.
 */
class SkillTreeFull(
        id: Int,
        name: String?,
        description: String?,
        icon_color: String?,

        val skills: List<Skill>
) : SkillTree(id, name, description, icon_color)

data class Skill(
        val skilltree_id: Int,
        val level: Int,
        val description: String?
)

class SkillQuantity(
        @Embedded(prefix = "skill_") val skillTree: SkillTreeBase,
        val quantity: Int
)