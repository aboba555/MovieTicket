document.querySelectorAll('.minus').forEach(button => {
    button.addEventListener('click', function(event) {
        event.preventDefault();
        let input = this.nextElementSibling;
        let value = parseInt(input.value);
        if (value > 1) {
            input.value = value - 1;
        }
    });
});

document.querySelectorAll('.plus').forEach(button => {
    button.addEventListener('click', function(event) {
        event.preventDefault();
        let input = this.previousElementSibling;
        let value = parseInt(input.value);
        let max = parseInt(input.max);
        if (value < max) {
            input.value = value + 1;
        }
    });
});
