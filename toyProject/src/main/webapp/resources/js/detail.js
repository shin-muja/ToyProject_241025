const stdNo = new URLSearchParams(location.search).get("stdNo");

const mainTo = document.querySelector("#main");
const updateTo = document.querySelector("#update");
const deleteTo = document.querySelector("#delete");

mainTo.addEventListener("click", () => {
	location.href = "/";
});


updateTo.addEventListener("click", () => {
	
	location.href = "/student/updateView?stdNo="+stdNo;
});

deleteTo.addEventListener("click", () => {
	
	if( !confirm("정말 삭제 하시겠습니까?") ) {
		return;
	}
	
	location.href = "/student/delete?stdNo="+stdNo;
	
});