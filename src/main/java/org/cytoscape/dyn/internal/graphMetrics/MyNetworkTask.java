package org.cytoscape.dyn.internal.graphMetrics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.cytoscape.dyn.internal.view.model.DynNetworkView;
import org.cytoscape.dyn.internal.view.model.DynNetworkViewManagerImpl;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.dyn.internal.model.snapshot.DynNetworkSnapshotImpl;

public class MyNetworkTask<T> extends AbstractTask{
	
	private DynNetworkViewManagerImpl<T> dynNetViewManager;
	
	public MyNetworkTask(DynNetworkViewManagerImpl dynNetViewManager){
		this.dynNetViewManager=dynNetViewManager;
	}
	
	public void run(TaskMonitor monitor){
		Collection<DynNetworkView<T>> dyncollection=new ArrayList<DynNetworkView<T>>();
		dyncollection=dynNetViewManager.getDynNetworkViews();
		Iterator<DynNetworkView<T>> it=dyncollection.iterator();
		DynNetworkView<T> view=it.next();
		System.out.println(view.getVisibleNodes());
		System.out.println(view.getVisibleEdges());
		view.updateView();
		
		//DynNetworkSnapshotImpl<T> snap=new DynNetworkSnapshotImpl<T>((DynNetworkView<T>) it.next());
		//System.out.println(snap.getEdgeCount());
	}

}
