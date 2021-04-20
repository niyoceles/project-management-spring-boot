var nicechartData = decodeHtml(chartData);

new Chart(document.getElementById("myPieChart"),{
  type: 'pie',
  data : {
  labels: [
  'January',
  'February',
  'March',
],
  datasets: [{
    label: 'My First dataset',
    backgroundColor: ['rgb(205, 55, 132)','rgb(255, 77, 132)','rgb(215, 22, 132)' ],
    borderColor: 'rgb(255, 109, 202)',
    data: [4, 10, 5],
  }],
  },
  options:{}
} );

//[{"value":1, "label":"COMPLETED"},{"value":1, "label":"INPROGRESS"},{"value":1, "label":"NOTSTARTED"}]

function decodeHtml(html){
	var text = document.createElement("textarea");
	text.innerHTML = html;
	return text.value;
	
}