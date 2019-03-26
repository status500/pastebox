new Vue({
    el: '#paste_form',
    data: {
        title: '',
        content: '',
        errorMessage: '',
        successMessage: ''
    },
    methods: {
        submitForm: function () {
            var payload = {
                title: this.title.trim(),
                content: this.content.trim()
            };
            this.$http.post('/paste', payload).then(function () {
                this.title = '';
                this.content = '';
                this.successMessage = 'Success, paste submitted';
            }, function () {
                this.errorMessage = 'Paste submission failed :-( ';
            });

        }
    }
});