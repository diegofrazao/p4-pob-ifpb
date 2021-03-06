/* This file is part of the db4o object database http://www.db4o.com

Copyright (C) 2004 - 2011  Versant Corporation http://www.versant.com

db4o is free software; you can redistribute it and/or modify it under
the terms of version 3 of the GNU General Public License as published
by the Free Software Foundation.

db4o is distributed in the hope that it will be useful, but WITHOUT ANY
WARRANTY; without even the implied warranty of MERCHANTABILITY or
FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
for more details.

You should have received a copy of the GNU General Public License along
with this program.  If not, see http://www.gnu.org/licenses/. */
package com.db4o.db4ounit.jre12.collections;

import java.util.*;

import com.db4o.query.*;

import db4ounit.*;
import db4ounit.extensions.*;

@decaf.Remove(decaf.Platform.JDK11)
public class MixedCollectionTestCase extends AbstractDb4oTestCase{
	
	public static class ListHolder {
		
		public List list;
		
		public ListHolder(List list) {
			this.list = list;
		}
	}
	
	public static class Item {
		
		public String name;
		
		public Item(String name) {
			this.name = name;
		}
		
	}
	
	@Override
	protected void store() throws Exception {
		ArrayList list = new ArrayList();
		list.add("42");
		list.add(new Item("item"));
		ListHolder listHolder = new ListHolder(list);
		store(listHolder);
	}
	
	public void test(){
		ListHolder listHolder = retrieveOnlyInstance(ListHolder.class);
		Assert.areEqual("42", listHolder.list.get(0));
	}
	
	public void testStringQuery(){
		assertStringQuery(1, "42");
		assertStringQuery(0, "43");
	}
	
	public void testItemQuery(){
		assertItemQuery("item", 1);
		assertItemQuery("invalid", 0);
	}

	private void assertItemQuery(String constraint, int expected) {
		Query query = db().query();
		query.constrain(ListHolder.class);
		query.descend("list").descend("name").constrain(constraint);
		Assert.areEqual(expected, query.execute().size());
	}

	private void assertStringQuery(int expected, String valueToQuery) {
		Query query = db().query();
		query.constrain(ListHolder.class);
		query.descend("list").constrain(valueToQuery);
		Assert.areEqual(expected, query.execute().size());
	}


}
