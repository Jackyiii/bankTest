const request = () => {
    const get = ({url, successFun, errorFun}) => {
        $.ajax({
            url: `http://localhost:8080/${url}`,
            type: 'get',
            contentType: 'application/json',
            success: res => {
                if (res.result === 0) {
                    if (successFun && res.data) {
                        successFun(res.data)
                    } else {
                        successFun(res)
                    }
                } else {
                    alert(res.msg)
                    if (errorFun) {
                        errorFun()
                    }
                }
            },
            error: err => {
                console.error(err)
                alert('Unknown Error!')
                if (errorFun) {
                    errorFun(err)
                }
            }
        })
    }

    const post = ({url, data, successFun, errorFun}) => {
        $.ajax({
            url: `http://localhost:8080/${url}`,
            data: JSON.stringify(data),
            type: 'post',
            contentType: 'application/json',
            success: res => {
                if (res.result === 0) {
                    if (successFun && res.data) {
                        successFun(res.data)
                    } else {
                        successFun(res)
                    }
                } else {
                    alert(res.msg)
                    if (errorFun) {
                        errorFun()
                    }
                }
            },
            error: err => {
                console.error(err)
                alert('Unknown Error!')
                if (errorFun) {
                    errorFun(err)
                }
            }
        })
    }

    return { get, post }
}
const { get, post } = request()