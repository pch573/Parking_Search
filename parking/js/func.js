		  function add_row(val1, val2, val3, val4, val5) {
			var table = document.getElementById('result');
			var row = table.insertRow(1); // ��ܿ� �߰�
			//var row = my_tbody.insertRow( my_tbody.rows.length ); // �ϴܿ� �߰�
			row.insertCell(0).innerHTML = val1;
			row.insertCell(1).innerHTML = val2;
			row.insertCell(2).innerHTML = val3;
			row.insertCell(3).innerHTML = val4;
			row.insertCell(4).innerHTML = val5;

		  }

		  function delete_row() {
			var table = document.getElementById('result');
			if (table.rows.length < 1) return;
			// my_tbody.deleteRow(0); // ��ܺ��� ����
			table.deleteRow( table.rows.length-1 ); // �ϴܺ��� ����
		  }
			function add_list(item){
				var table = document.getElementById('subkeywords').getElementsByTagName('tbody')[0];
				var row = table.insertRow(0); // ��ܿ� �߰�
				var td1 = row.insertCell(0);
				var td2 = row.insertCell(1);
				td1.setAttribute("class","col-4");
				td2.setAttribute("class","col-8");
				td1.innerHTML = table.rows.length;
				td2.innerHTML = item;
				/*var opt = document.createElement("option");
				opt.text = item;
				opt.value = item;
				document.getElementById("subkeywords").options.add(opt);
				return false;*/
			}

			function get_subkeywords(){
				var input = document.getElementById("keywordlist").value;
				var keywordslist = input.split('\n');
				var e = document.getElementById("degree");
				var degree = e.options[e.selectedIndex].value;
				for(var i = 0; i < keywordslist.length; i++){
					$.ajax({
						url: "libs/get_subkeywords.php",
						type: "post",
						data: "query=" + keywordslist[i] + "&degree=" + degree,
					}).done(function(data) {
						var dataArr = data.split("||");
						for(var j = 0; j < dataArr.length - 1; j++){
							add_list(dataArr[j]);
							
						}
					});
				}
			}

			function get_result(){
				var addr = document.getElementById("pAddr").value;
				var pname = document.getElementById("pName").value;
				var table = document.getElementById('result');
				//var keywordlists = document.getElementById("subkeywords");
				//var listLength = keywordlists.options.length;
				/*$.ajax({
						url: "libs/get_result.php",
						type: "post",
						data: "paddr=" + addr + "&pname=" + pname,
					}).done(function(data) {
						var dataArr = data.split("||");
						add_row(dataArr[0], dataArr[1], dataArr[2], dataArr[3], dataArr[4]);
					});*/
			}