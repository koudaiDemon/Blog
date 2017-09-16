function goPageLoginInfo(cp,mid){
	$.get('list?flag=loadInfo',{'cp':cp,'mid':mid},function(data){
	var tr = ''
	for(var i = 0 ; i < data.list.length ; i++){
		tr += '<tr>';
		tr += '<td>'+data.list[i].loadIp+'</td>';
		var lastLoadTime = new Date();
		lastLoadTime.setTime(data.list[i].loadTime);
		var time = lastLoadTime.getFullYear()+'-'+(lastLoadTime.getMonth()+1)+'-'+lastLoadTime.getDate()+'  '+lastLoadTime.getHours()+':'+lastLoadTime.getMinutes()+':'+lastLoadTime.getSeconds();
		tr += '<td>'+time+'</td>';
		tr += '<td>成功</td>';
		tr += '</tr>';
		}
		$('#loadInfo').html($(tr));
		genLoadPageLink(data,mid);
	})
}
//生成分页连接函数
function genLoadPageLink(pd,mid){
	var totalList = 4;//限制最多显示6页
	var cp = pd.currentPage;//当前页
	var total = pd.totalPage;//总页数
	var pre = cp -1;	//上一页
	var next = cp +1;	//下一页
	
	var start = 1;
	var end = totalList;
	//限制总页数显示
	if(cp >= totalList){
		start = cp - 2;
		end = cp + 2;
		if(end >= total){
			end = total;
		}
		if(end > total-2){
			start = total-3;
		}
	}else{
		start = 1;
		if(cp == 3){
			start = cp - 1;
			end = cp + 1;
		}
		if(end >= total){
			end = total;
		}
	}
	var ul = '<ul class="pagination">';
	if(pd.currentPage == 1){
		ul += '<li class="disabled"><a href="javascript:goPageLoginInfo('+pd.pre+','+mid+')">&laquo;</a></li>'
	}else{
		ul += '<li><a href="javascript:goPageLoginInfo('+pd.pre+','+mid+')">&laquo;</a></li>'
	}
	for(var i = start ; i <= end ; i++){
		//如果当前遍历到的页码数等于当前页，则当前页码被激活class='active'
		if(pd.currentPage == i){
			ul += '<li class="active"><a href="javascript:goPageLoginInfo('+i+','+mid+')">'+i+'</li>';
		}else{
			ul += '<li><a href="javascript:goPageLoginInfo('+i+','+mid+')">'+i+'</li>';
		}
	}
	if(pd.currentPage == pd.totalPage){
		ul += '<li class="disabled"><a href="javascript:goPageLoginInfo('+pd.next+','+mid+')">&raquo;</a></li>'
	}else{
		ul += '<li><a href="javascript:goPageLoginInfo('+pd.next+','+mid+')">&raquo;</a></li>'
	}
	ul +='</ul>';
	$('#loadInfopaging').html($(ul));
}
