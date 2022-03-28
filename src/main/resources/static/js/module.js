const store = {
    namespaced: true,
    //para retornar el objeto pasamos los parebtesis sobre el objeto
    state: () => ({
        impuesto: null,
        saldoRestaste: null,
        completed: null,
        loading: null

    }),
    mutations: {
        handlerImpuesto(state, value) {
            state.impuesto = value
        },
        handlerSaldoRestante(state, value) {
            state.saldoRestaste = value
        },
        handlerCompleted(state, value) {
            state.completed = value
        },
        handlerLoading(state, value) {
            state.loading = value
        },

    },
    actions: {
        async process({commit}, dxc) {
            try {
                commit('handlerCompleted', false);
                commit('handlerLoading', true);
                const {sueldo, ahorro} = dxc
                const retiroResponse = await axios.get('/rest/msdxc/dxc', {params: {sueldo: sueldo, ahorro: ahorro}});
                console.log("retiro: ", retiroResponse.data)
                const impuestoResponse = await axios.get('/rest/msdxc/impuesto', {
                    params: {
                        sueldo: sueldo,
                        retiro: retiroResponse.data
                    }
                });
                console.log("impuesto: ", impuestoResponse.data)
                commit('handlerImpuesto', impuestoResponse.data)

                const saldoRestante = await axios.get('/rest/msdxc/saldoRestante', {params: {ahorro: ahorro}});
                console.log("impuesto: ", saldoRestante.data)
                commit('handlerSaldoRestante', saldoRestante.data)
                commit('handlerLoading', false);
                commit('handlerCompleted', true);
            } catch (e) {
                console.error(e)
            }

        }
    }
}

export default store