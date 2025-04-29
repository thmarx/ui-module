window.addEventListener("DOMContentLoaded", () => {
	const actionElements = document.querySelectorAll('[data-action-definition]');
	actionElements.forEach(element => {
		try {
			element.addEventListener("click", (action) => {
				const definition = element.getAttribute('data-action-definition');
				try {
					const action = JSON.parse(definition);
					console.log(action)
					if (action.type === "hook") {
						executeHookAction(action)
					}

				} catch (e) {
					console.error('error parsing error definition', e);
				}
			})
		} catch (e) {
			console.error('', e);
		}
	});
})

const executeHookAction = async (action) => {
	var data = {
		type : action.hook
	}
	if (action.parameters) {
		data.parameters = action.parameters
	}
	const response = await fetch("/module/ui-module/hooks", {
		method: "POST",
		body: JSON.stringify(data)
	});
}