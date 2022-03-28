import store from "./module.js";

const store2 = Vuex.createStore({
    modules: {
        dxc: store
    }
})
const app = Vue.createApp({

    setup() {
        const userForm = Vue.ref({
            sueldo: null,
            ahorro: null,
        })
        return {
            userForm,
            doDxc: () => store2.dispatch('dxc/process', userForm.value),
            impuesto: Vue.computed(() => store2.state.dxc.impuesto),
            saldo: Vue.computed(() => store2.state.dxc.saldoRestaste),
            isReady: Vue.computed(() => store2.state.dxc.completed),
            isLoad: Vue.computed(() => store2.state.dxc.loading),
            ten: Vue.computed(() => store2.state.dxc.ten),
        }
    },  // view
    template: `

<form @submit.prevent="doDxc">
<label for="s" class="form-label">Ingrese Sueldo</label>
  <div class="input-group mb-3">
    <span class="input-group-text">$</span>
    <input v-model="userForm.sueldo" type="text" class="form-control" id="s">
  </div>
  <label for="a" class="form-label">Ingrese Ahorro</label>
  <div class="input-group mb-3">
     <span class="input-group-text">$</span>
    <input v-model="userForm.ahorro" type="text" class="form-control" id="a">
  </div>
  <button type="submit" class="btn btn-primary">Conoce tu 10</button>
</form>
<br>

<div class="d-flex justify-content-center" v-if="isReady">
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Impuesto</h5>
    <h6 class="card-subtitle mb-2 text-muted">Valor del impuesto a pagar</h6>
    <h6 class="card-text" id="resultado_impuesto">$ {{impuesto}}</h6>
  </div>
</div>
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Saldo Restante</h5>
    <h6 class="card-subtitle mb-2 text-muted">Tu saldo restante</h6>
    <h6 class="card-text" id="resultado_saldo">$ {{saldo}}</h6>
  </div>
  </div>
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Tu 10%</h5>
    <h6 class="card-subtitle mb-2 text-muted">Tu 10% hoy</h6>
    <h6 class="card-text" id="resultado_diez">$ {{ten}}</h6>
  </div>
 </div>
</div>
  <div class="d-flex justify-content-center" v-if="isLoad">
  <div class="spinner-border" role="status">
    <span class="visually-hidden">Loading...</span>
  </div>
  </div>

    `,

}).use(store2)
    .mount('#app')
