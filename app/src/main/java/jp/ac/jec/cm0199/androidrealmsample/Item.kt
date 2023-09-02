package jp.ac.jec.cm0199.androidrealmsample

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class Item() : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var isComplete: Boolean = false
    var summary: String = ""
    var owner_id: String = ""

    constructor(ownerId: String = "") : this() {
        owner_id = ownerId
    }

    override fun toString(): String {
        return "Item(_id=$_id, isComplete=$isComplete, summary='$summary', owner_id='$owner_id')"
    }
}