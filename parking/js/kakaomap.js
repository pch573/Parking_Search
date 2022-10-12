var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = { 
	center: new daum.maps.LatLng(map_lat, map_lon), // 지도의 중심좌표
	level: 3 // 지도의 확대 레벨
};  

var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
    




var markerPosition  = new daum.maps.LatLng(map_lat, map_lon); 

// 마커를 생성합니다
var marker = new daum.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다




// 인포윈도우를 생성합니다
var infowindow = new daum.maps.InfoWindow({
    position : iwPosition, 
    content : iwContent 
});

marker.setMap(map);
infowindow.open(map, marker); 






// 지도타입 컨트롤의 지도 또는 스카이뷰 버튼을 클릭하면 호출되어 지도타입을 바꾸는 함수입니다
function setMapType(maptype) { 
    var roadmapControl = document.getElementById('btnRoadmap');
    var skyviewControl = document.getElementById('btnSkyview'); 
    if (maptype === 'roadmap') {
        map.setMapTypeId(daum.maps.MapTypeId.ROADMAP);    
        roadmapControl.className = 'km_selected_btn';
        skyviewControl.className = 'km_btn';
    } else {
        map.setMapTypeId(daum.maps.MapTypeId.HYBRID);    
        skyviewControl.className = 'km_selected_btn';
        roadmapControl.className = 'km_btn';
    }
}

// 지도 확대, 축소 컨트롤에서 확대 버튼을 누르면 호출되어 지도를 확대하는 함수입니다
function zoomIn() {
    map.setLevel(map.getLevel() - 1);
}

// 지도 확대, 축소 컨트롤에서 축소 버튼을 누르면 호출되어 지도를 확대하는 함수입니다
function zoomOut() {
    map.setLevel(map.getLevel() + 1);
}