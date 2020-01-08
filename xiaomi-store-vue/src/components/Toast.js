const toast = {
    error(source, message) {
        source.toast(message, {
            variant: "danger",
            solid: true,
            autoHideDelay: 3000
        })
    },
    info(source, message) {
        source.toast(message, {
            variant: "info",
            solid: true,
            autoHideDelay: 3000
        })
    },
    success(source, message) {
        source.toast(message, {
            variant: "success",
            solid: true,
            autoHideDelay: 2000
        })
    },
    warning(source, message) {
        source.toast(message, {
            variant: "warning",
            solid: true,
            autoHideDelay: 3000
        })
    }
}

export default toast;