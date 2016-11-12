package com.jakibah.infinyvale.lists;

import com.jakibah.infinyvale.BagItem;
import com.jakibah.infinyvale.items.HealPotion;

public class Items {
	
	public static BagItem get(String name){
		
	if(name.equals("HealPotion")){
		return new HealPotion(null, null, null, 0, 0, 0);
	}else{
		return null;
	}
	}

}
