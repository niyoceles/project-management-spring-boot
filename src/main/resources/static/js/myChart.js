var chartDataStr = decodeHtml(chartData);

var chartDataArray= JSON.parse(chartDataStr);

var arrayLength = chartDataArray.length;

var numbericData = [];
var labelData = [];

for(i=0; i<arrayLength; i++){
	numbericData[i] = chartDataArray[i].value;
    labelData[i] = chartDataArray[i].label;	
}

new Chart(document.getElementById("myPieChart"),{
  type: 'pie',
  data : {
  labels: labelData,
  datasets: [{
    label: 'My First dataset',
    backgroundColor: ['#3EBF95','#428DC4','#814897' ],
   // borderColor: 'rgb(255, 109, 202)',
    data: numbericData,
  }],
  },
  options:{
	title:{
		display:true,
		text:'Project Status'
	}
}
} );

//[{"value":1, "label":"COMPLETED"},{"value":1, "label":"INPROGRESS"},{"value":1, "label":"NOTSTARTED"}]

function decodeHtml(html){
	var text = document.createElement("textarea");
	text.innerHTML = html;
	return text.value;
	
}