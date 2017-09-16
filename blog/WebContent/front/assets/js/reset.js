/**
 * 
 * 
 * 
 */
$.get('list',{'flag':'notice','cp':'1'},function(data){
	var li = '';
	var basePath = '192.168.46.13:8080/imageDB/';
	for(var i = 1 ; i < data.list.length ; i++){
		li += '<img src="'+data.list[i].imgSrc+'">';
		li += '<div class="blog-slider-desc am-slider-desc ">';
		li += '<div class="blog-text-center blog-slider-con">';
		li += '<span><a href="" class="blog-color">Article &nbsp;</a></span>';
		li += '<h1 class="blog-h-margin"><a href="">'+data.list[i].title+'</a></h1>';
		li += data.list[i].content;
		var lastLoadTime = new Date();
		lastLoadTime.setTime(data.list[i].submitTime);
		var time = lastLoadTime.getFullYear()+'/'+(lastLoadTime.getMonth()+1)+'/'+lastLoadTime.getDate();
		li += '<span class="blog-bor">'+time+'</span>';
		li += '</div></div></li>';
	}
	$('#notice').html($(li));
})